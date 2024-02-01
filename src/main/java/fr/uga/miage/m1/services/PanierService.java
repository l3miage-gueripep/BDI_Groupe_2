package fr.uga.miage.m1.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.Etat;
import fr.uga.miage.m1.dto.PanierDto;
import fr.uga.miage.m1.entities.CovoiturageLieu;
import fr.uga.miage.m1.entities.OffreCovoiturage;
import fr.uga.miage.m1.entities.Panier;
import fr.uga.miage.m1.entities.PanierOffre;
import fr.uga.miage.m1.mapper.PanierMapper;
import fr.uga.miage.m1.repos.AdherentRepo;
import fr.uga.miage.m1.repos.OffreCovoiturageRepo;
import fr.uga.miage.m1.repos.PanierRepo;
import fr.uga.miage.m1.requests.CreatePanierRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;



@Service
@Transactional
@RequiredArgsConstructor
public class PanierService {
    private final PanierRepo repo;
    private final PanierMapper mapper;
    private final AdherentRepo adherentRepo;
    private final OffreCovoiturageRepo offreCovoiturageRepo;

    private final CovoiturageLieuService covoiturageLieuService;

    private final PanierOffreService panierOffreService;

    private final AdherentService adherentService;

    public PanierDto create(CreatePanierRequest createPanierRequest) {
        PanierDto panierDto = new PanierDto();
        panierDto.setEtat(createPanierRequest.getEtat());
        panierDto.setDatePanier(createPanierRequest.getDatePanier());
        Panier entity = mapper.toEntity(panierDto);
        entity.setAdherent(adherentRepo.findByMail(createPanierRequest.getUserMail()));
        return mapper.toDto(repo.save(entity));
    }

    public List<PanierDto> getAll() {
        List<Panier> paniers = repo.findAll();
        return  paniers.stream()
        .map(mapper::toDto)
        .toList();
    }

    public PanierDto addLieu(String userMail, Long idLieu, int quantite) {
        Panier panier = this.getCurrentPanierEntityByUserMail(userMail)
            .orElse(Panier.builder()
                .adherent(adherentService.findByMailOrCreate(userMail))
                .etat(Etat.valueOf("ENCOURS"))
                .datePanier(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build());

        CovoiturageLieu covoiturageLieu = covoiturageLieuService.getEntityById(idLieu);
        PanierOffre panierOffre = PanierOffre.builder()
            .panier(panier)
            .covoiturageLieu(covoiturageLieu)
            .quantite(quantite)
            .build();
        panierOffre.setPanier(panier);
        panierOffre = panierOffreService.save(panierOffre);
        panier.getPanierOffres().add(panierOffre);
        return mapper.toDto(repo.save(panier));
    }


    public Optional<PanierDto> getCurrentPanierByUserMail(String userMail) {
        Optional<Panier> panierOptional = this.getCurrentPanierEntityByUserMail(userMail);
        if (panierOptional.isPresent()) {
            Panier panier = panierOptional.get();
            return Optional.of(mapper.toDto(panier));
        } else {
            return Optional.empty();
        }
    }
    public Optional<Panier> getCurrentPanierEntityByUserMail(String userMail) {
        return repo.findByAdherentMailAndEtat(userMail, Etat.valueOf("ENCOURS"));
    }


    public PanierDto setEtatToPaye(Long idPanier) throws Exception {
        Optional<Panier> optionalPanier = repo.findById(idPanier);
        if (optionalPanier.isPresent()) {
            Panier panier = optionalPanier.get();
            List<PanierOffre> panierOffres = panier.getPanierOffres();
            try {
                updateQuantitesAndCheckAvailability(panierOffres);
                panier.setEtat(Etat.valueOf("PAYE"));
            } catch (RuntimeException e) {
                panier.setEtat(Etat.valueOf("ECHEC"));
                System.err.println(e.getMessage());
                return null;
            }
            return mapper.toDto(repo.save(panier));
        } else {
            return null;
        }
    }
    

    public void updateQuantitesAndCheckAvailability(List<PanierOffre> panierOffres) throws Exception {
        for (PanierOffre panierOffre : panierOffres) {
            OffreCovoiturage offreCovoiturage = panierOffre.getCovoiturageLieu().getOffreCovoiturage();
            if (panierOffre.getQuantite() > offreCovoiturage.getNbPlaces()) {
                throw new Exception("Échec : La quantité demandée pour l'offre " + offreCovoiturage.getIdOffreCovoiturage() + panierOffre.getQuantite() + 
                " dépasse le nombre de places disponibles." + offreCovoiturage.getNbPlaces());
            }
        }
        // Si toutes les offres ont suffisamment de places, procéder à la mise à jour
        panierOffres.forEach(this::updateOffreCovoiturageQuantite);
    }
    

private void updateOffreCovoiturageQuantite(PanierOffre panierOffre) {
    OffreCovoiturage offreCovoiturage = panierOffre.getCovoiturageLieu().getOffreCovoiturage();
    int newNbPlaces = offreCovoiturage.getNbPlaces() - panierOffre.getQuantite();
    offreCovoiturage.setNbPlaces(newNbPlaces);
    offreCovoiturageRepo.save(offreCovoiturage); 
}


}
