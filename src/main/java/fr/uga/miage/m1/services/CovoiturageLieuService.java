package fr.uga.miage.m1.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.dto.CovoiturageLieuDto;
import fr.uga.miage.m1.entities.CovoiturageLieu;
import fr.uga.miage.m1.mapper.CovoiturageLieuMapper;
import fr.uga.miage.m1.mapper.LieuCovoiturageMapper;
import fr.uga.miage.m1.mapper.OffreCovoiturageMapper;
import fr.uga.miage.m1.repos.CovoiturageLieuRepo;
import fr.uga.miage.m1.repos.OffreCovoiturageRepo;
import fr.uga.miage.m1.requests.CreateCovoiturageLieuRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CovoiturageLieuService {
    private final CovoiturageLieuRepo repo;
    private final CovoiturageLieuMapper mapper;

    private final OffreCovoiturageMapper offreCovoiturageMapper;
    private final OffreCovoiturageService offreCovoiturageService;

    private final LieuCovoiturageMapper lieuCovoiturageMapper;
    private final LieuCovoiturageService lieuCovoiturageService;

    public CovoiturageLieuDto create(CreateCovoiturageLieuRequest covoiturageLieuDto) {
        CovoiturageLieu covoiturageLieu = new CovoiturageLieu();
        covoiturageLieu.setPrix(covoiturageLieuDto.getPrix());
        covoiturageLieu.setHoraire(covoiturageLieuDto.getHoraire());
        covoiturageLieu.setOffreCovoiturage(offreCovoiturageMapper.toEntity(offreCovoiturageService.getById(covoiturageLieuDto.getIdOffreCovoiturage())));
        covoiturageLieu.setLieuCovoiturage(lieuCovoiturageMapper.toEntity(lieuCovoiturageService.getById(covoiturageLieuDto.getIdLieuCovoiturage())));
        return mapper.toDto(repo.save(covoiturageLieu));
    }

    public CovoiturageLieuDto save(CovoiturageLieu covoiturageLieuDto) {
        return mapper.toDto(repo.save(covoiturageLieuDto));
    }

    public List<CovoiturageLieuDto> getAll() {
        List<CovoiturageLieuDto> covoiturageLieux = repo.findAll().stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
        return covoiturageLieux;
    }

    public CovoiturageLieuDto getById(Long id) {
        return mapper.toDto(getEntityById(id));
    }

    public CovoiturageLieu getEntityById(Long id) {
        return repo.findById(id).get();
    }
}
