package fr.uga.miage.m1.services;

import java.util.List;
import java.util.Optional;

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
        
        return lieuCovoiturageRepo.findAll().stream()
            .map(lieuCovoiturageMapper::toDto)
            .toList();
    }

    public LieuCovoiturageDto getById(String idLieuCovoiturage) {
        //code original avant sonar
        //LieuCovoiturage lieuCovoiturage = lieuCovoiturageRepo.findById(idLieuCovoiturage).get();
        //return lieuCovoiturageMapper.toDto(lieuCovoiturage);

        //code apres sonar ( vérifier que ça fonctionne)
        Optional<LieuCovoiturage> optionalLieuCovoiturage = lieuCovoiturageRepo.findById(idLieuCovoiturage);
        if (optionalLieuCovoiturage.isPresent()) {
            LieuCovoiturage lieuCovoiturage = optionalLieuCovoiturage.get();
            return lieuCovoiturageMapper.toDto(lieuCovoiturage);
        }
        return null; 
    }
}
