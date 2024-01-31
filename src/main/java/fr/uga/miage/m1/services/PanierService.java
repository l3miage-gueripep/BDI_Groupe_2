package fr.uga.miage.m1.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import fr.uga.miage.m1.Etat;
import fr.uga.miage.m1.dto.PanierDto;
import fr.uga.miage.m1.entities.CovoiturageLieu;
import fr.uga.miage.m1.entities.Festival;
import fr.uga.miage.m1.entities.Panier;
import fr.uga.miage.m1.entities.PanierOffre;
import fr.uga.miage.m1.mapper.CovoiturageLieuMapper;
import fr.uga.miage.m1.mapper.PanierMapper;
import fr.uga.miage.m1.repos.AdherentRepo;
import fr.uga.miage.m1.repos.PanierRepo;
import fr.uga.miage.m1.requests.CreatePanierRequest;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;



@Service
@Transactional
@RequiredArgsConstructor
public class PanierService {
    private final PanierRepo repo;
    private final PanierMapper mapper;
    private final AdherentRepo adherentRepo;

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
        List<PanierDto> paniersDtos = paniers.stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
        return paniersDtos;
    }

    public PanierDto addLieu(String userMail, Long idLieu, int quantite) {
        Panier panier = this.getCurrentPanierEntityByUserMail(userMail)
            .orElse(Panier.builder()
                .adherent(adherentService.findByMailOrCreate(userMail))
                .etat(Etat.valueOf("Encours"))
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
        return repo.findByAdherentMailAndEtat(userMail, Etat.valueOf("Encours"));
    }



    public PanierDto setEtatToPaye(Long idPanier) {
        Panier panier = repo.findById(idPanier).get();
        panier.setEtat(Etat.valueOf("Paye"));
        return mapper.toDto(repo.save(panier));
    }
}
