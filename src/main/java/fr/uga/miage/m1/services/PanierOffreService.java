package fr.uga.miage.m1.services;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.entities.PanierOffre;
import fr.uga.miage.m1.repos.PanierOffreRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PanierOffreService {
    private final PanierOffreRepo repo;

    public PanierOffre save(PanierOffre panierOffre) {
        return this.repo.save(panierOffre);
    }

    public void deleteAll() {
        this.repo.deleteAll();
    }

    public void deleteById(Long idPanierOffre) {
        this.repo.deleteByIdPanierOffre(idPanierOffre);
    }
    
}
