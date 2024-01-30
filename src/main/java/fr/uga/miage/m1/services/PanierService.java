package fr.uga.miage.m1.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.dto.PanierDto;
import fr.uga.miage.m1.entities.CovoiturageLieu;
import fr.uga.miage.m1.entities.Panier;
import fr.uga.miage.m1.mapper.AdherentMapper;
import fr.uga.miage.m1.mapper.CovoiturageLieuMapper;
import fr.uga.miage.m1.mapper.PanierMapper;
import fr.uga.miage.m1.repos.AdherentRepo;
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

    private final CovoiturageLieuService covoiturageLieuService;
    private final CovoiturageLieuMapper covoiturageLieuMapper;

    public PanierDto create(CreatePanierRequest createPanierRequest) {
        PanierDto panierDto = new PanierDto();
        panierDto.setPrix(createPanierRequest.getPrix());
        panierDto.setNbPlaces(createPanierRequest.getNbPlaces());
        panierDto.setEtat(createPanierRequest.getEtat());
        panierDto.setDatePanier(createPanierRequest.getDatePanier());
        Panier entity = mapper.toEntity(panierDto);
        entity.setAdherent(adherentRepo.findByMail(createPanierRequest.getUserMail()));
        return mapper.toDto(repo.save(entity));
    }

    public List<PanierDto> getAll() {
        List<PanierDto> paniers = repo.findAll().stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
        return paniers;
    }

    public PanierDto addLieu(Long idPanier, Long idLieu) {
        Panier panier = repo.findById(idPanier).get();
        CovoiturageLieu covoiturageLieu = covoiturageLieuMapper.toEntity(covoiturageLieuService.getById(idLieu));
        panier.getPanierOffres().
        return mapper.toDto(repo.save(panier));
    }
}
