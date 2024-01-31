package fr.uga.miage.m1.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.uga.miage.m1.dto.OffreCovoiturageDto;
import fr.uga.miage.m1.entities.OffreCovoiturage;
import fr.uga.miage.m1.mapper.OffreCovoiturageMapper;
import fr.uga.miage.m1.repos.OffreCovoiturageRepo;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OffreCovoiturageService {
    private final OffreCovoiturageRepo repo;
    private final OffreCovoiturageMapper mapper;

    public OffreCovoiturageDto create(OffreCovoiturageDto offreCovoiturageDto) {
        OffreCovoiturage offreCovoiturageEntity = mapper.toEntity(offreCovoiturageDto);
        return mapper.toDto(repo.save(offreCovoiturageEntity));
    }

    public List<OffreCovoiturageDto> getAll(@NonNull Pageable pageable) {
        Page<OffreCovoiturage> offresCovoiturage = repo.findAll(pageable);
        return offresCovoiturage.stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<OffreCovoiturageDto> getAllByFestival(Pageable pageable, String nomManifestation) {
        Page<OffreCovoiturage> offresCovoiturage = repo.findAllByFestivalNomManifestation(nomManifestation, pageable);
        return offresCovoiturage.stream()
                .map(mapper::toDto)
                .toList();
    }

    public OffreCovoiturageDto getById(Long idOffre) {
        Optional<OffreCovoiturage> optionalOffreCovoit = repo.findById(idOffre);
        OffreCovoiturage offreCovoiturage = null;
        if (optionalOffreCovoit.isPresent()) {
            offreCovoiturage = optionalOffreCovoit.get();
        } else {
            throw new NoSuchElementException("Aucune offre de covoiturage trouvée");
        }
        return mapper.toDto(offreCovoiturage);
    }

    public OffreCovoiturageDto prendrePlaces(Long idOffre, int nbPlaces) {
        Optional<OffreCovoiturage> optionalOffreCovoit = repo.findById(idOffre);
        OffreCovoiturage offreCovoiturage = null;
        if (optionalOffreCovoit.isPresent()) {
            offreCovoiturage = optionalOffreCovoit.get();
        } else {
            throw new NoSuchElementException("Aucune offre covoitutrage trouvée");
        }
        offreCovoiturage.setNbPlaces(offreCovoiturage.getNbPlaces() - nbPlaces);
        repo.save(offreCovoiturage);
        return mapper.toDto(offreCovoiturage);
    }
}
