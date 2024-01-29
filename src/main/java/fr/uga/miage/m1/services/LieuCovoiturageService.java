package fr.uga.miage.m1.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.dto.LieuCovoiturageDto;
import fr.uga.miage.m1.entities.LieuCovoiturage;
import fr.uga.miage.m1.mapper.LieuCovoiturageMapper;
import fr.uga.miage.m1.repos.LieuCovoiturageRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class LieuCovoiturageService {
    private final LieuCovoiturageRepo lieuCovoiturageRepo;
    private final LieuCovoiturageMapper lieuCovoiturageMapper;

    public LieuCovoiturage create(LieuCovoiturage lieuCovoiturage) {
        return lieuCovoiturageRepo.save(lieuCovoiturage);
    }

    public List<LieuCovoiturageDto> getAll() {
        List<LieuCovoiturageDto> lieuCovoiturages = lieuCovoiturageRepo.findAll().stream()
            .map(lieuCovoiturageMapper::toDto)
            .collect(Collectors.toList());
        return lieuCovoiturages;
    }

    public LieuCovoiturageDto getById(String idLieuCovoiturage) {
        LieuCovoiturage lieuCovoiturage = lieuCovoiturageRepo.findById(idLieuCovoiturage).get();
        return lieuCovoiturageMapper.toDto(lieuCovoiturage);
    }
}
