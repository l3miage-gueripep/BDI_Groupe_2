package fr.uga.miage.m1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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
    private final CovoiturageLieuMapper covoiturageLieuMapper;

    private final PanierOffreService panierOffreService;

    private final EntityManager entityManager;

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

    public PanierDto addLieu(Long idPanier, Long idLieu) {
        Panier panier = repo.findById(idPanier).get();
        CovoiturageLieu covoiturageLieu = covoiturageLieuService.getEntityById(idLieu);
        Festival festival = covoiturageLieu.getOffreCovoiturage().getFestival();
        //find the panierOffre with the same festival or create a new one
        PanierOffre panierOffre = panier.getPanierOffres().stream()
                    .filter(p -> p.getFestival() != null && p.getFestival().equals(festival))
                    .findFirst()
                    .orElse(PanierOffre.builder()
                        .panier(panier)
                        .covoiturageLieux(new ArrayList<>())
                        .build());
        panierOffre.setPanier(panier);
        panierOffre = panierOffreService.save(panierOffre);

        panierOffre.getCovoiturageLieux().add(covoiturageLieu);
        panierOffre.setPanier(panier);
        panier.getPanierOffres().add(panierOffre);
        return mapper.toDto(repo.save(panier));
    }
}
