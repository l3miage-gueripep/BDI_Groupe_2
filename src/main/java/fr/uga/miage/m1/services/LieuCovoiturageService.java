package fr.uga.miage.m1.services;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.entities.LieuCovoiturage;
import fr.uga.miage.m1.repos.LieuCovoiturageRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class LieuCovoiturageService {
    private final LieuCovoiturageRepo lieuCovoiturageRepo;

    public LieuCovoiturage create(LieuCovoiturage lieuCovoiturage) {
        return lieuCovoiturageRepo.save(lieuCovoiturage);
    }
}
