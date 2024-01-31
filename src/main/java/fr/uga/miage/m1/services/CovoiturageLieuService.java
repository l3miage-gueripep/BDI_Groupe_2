package fr.uga.miage.m1.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.uga.miage.m1.dto.CovoiturageLieuDto;
import fr.uga.miage.m1.entities.CovoiturageLieu;
import fr.uga.miage.m1.mapper.CovoiturageLieuMapper;
import fr.uga.miage.m1.mapper.LieuCovoiturageMapper;
import fr.uga.miage.m1.mapper.OffreCovoiturageMapper;
import fr.uga.miage.m1.repos.CovoiturageLieuRepo;
import fr.uga.miage.m1.repos.OffreCovoiturageRepo;
import fr.uga.miage.m1.requests.CovoiturageLieuFilterRequest;
import fr.uga.miage.m1.requests.CreateCovoiturageLieuRequest;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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

    public Page<CovoiturageLieuDto> getAll(Pageable pageable) {
        Page<CovoiturageLieu> covoiturageLieux = repo.findAll(pageable);
        return covoiturageLieux.map(mapper::toDto);
    }

    public CovoiturageLieuDto getById(Long id) {
        return mapper.toDto(getEntityById(id));
    }

    public CovoiturageLieu getEntityById(Long id) {
        return repo.findById(id).get();
    }

    public List<CovoiturageLieuDto> getCovoituragesLieusByOffreCovoiturage(Long idOffreCovoiturage){
        List<CovoiturageLieuDto> covoiturageLieux = repo.findByOffreCovoiturageIdOffreCovoiturage(idOffreCovoiturage).stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
        return covoiturageLieux;
    }

    public Page<CovoiturageLieuDto> getByIdFestival(Pageable pageable, String nomManifestation){
        Page<CovoiturageLieu> covoiturageLieux = repo.findByOffreCovoiturageFestivalNomManifestation(pageable, nomManifestation);
        return covoiturageLieux.map(mapper::toDto);
    }



}
