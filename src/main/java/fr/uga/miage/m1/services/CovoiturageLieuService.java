package fr.uga.miage.m1.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.uga.miage.m1.dto.CovoiturageLieuDto;
import fr.uga.miage.m1.entities.CovoiturageLieu;
import fr.uga.miage.m1.mapper.CovoiturageLieuMapper;
import fr.uga.miage.m1.mapper.LieuCovoiturageMapper;
import fr.uga.miage.m1.mapper.OffreCovoiturageMapper;
import fr.uga.miage.m1.repos.CovoiturageLieuRepo;
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
        covoiturageLieu.setOffreCovoiturage(offreCovoiturageMapper
                .toEntity(offreCovoiturageService.getById(covoiturageLieuDto.getIdOffreCovoiturage())));
        covoiturageLieu.setLieuCovoiturage(lieuCovoiturageMapper
                .toEntity(lieuCovoiturageService.getById(covoiturageLieuDto.getIdLieuCovoiturage())));
        return mapper.toDto(repo.save(covoiturageLieu));
    }

    public CovoiturageLieuDto save(CovoiturageLieu covoiturageLieuDto) {
        return mapper.toDto(repo.save(covoiturageLieuDto));
    }

    public List<CovoiturageLieuDto> getAll() {
        return repo.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    public Page<CovoiturageLieuDto> getAll(Pageable pageable) {
        Page<CovoiturageLieu> covoiturageLieux = repo.findAll(pageable);
        return covoiturageLieux.map(mapper::toDto);

    }

    public CovoiturageLieuDto getById(Long id) {
        return mapper.toDto(getEntityById(id));
    }

    public CovoiturageLieu getEntityById(Long id) {
        Optional<CovoiturageLieu> optionalCovoitLieu = repo.findById(id);
        CovoiturageLieu covoitLieu = null;
        if (optionalCovoitLieu.isPresent()) {
            covoitLieu = optionalCovoitLieu.get();
        } else {
            throw new NoSuchElementException("Pas de covoiturageLieu trouvé");
        }
        return covoitLieu;
    }

    public List<CovoiturageLieuDto> getCovoituragesLieusByOffreCovoiturage(Long idOffreCovoiturage) {
        return repo.findByOffreCovoiturageIdOffreCovoiturage(idOffreCovoiturage)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public Page<CovoiturageLieuDto> getByIdFestival(Pageable pageable, String nomManifestation) {
        Page<CovoiturageLieu> covoiturageLieux = repo.findByOffreCovoiturageFestivalNomManifestation(pageable,
                nomManifestation);
        return covoiturageLieux.map(mapper::toDto);
    }



}
