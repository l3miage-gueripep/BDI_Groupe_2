package fr.uga.miage.m1.services;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.dto.PanierOffreDto;
import fr.uga.miage.m1.entities.PanierOffre;
import fr.uga.miage.m1.mapper.PanierOffreMapper;
import fr.uga.miage.m1.repos.PanierOffreRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PanierOffreService {
    private final PanierOffreRepo repo;
    private final PanierOffreMapper mapper;

    public PanierOffre save(PanierOffre panierOffre) {
        return this.repo.save(panierOffre);
    }

    public void deleteAll() {
        this.repo.deleteAll();
    }

    public void deleteById(Long idPanierOffre) {
        this.repo.deleteByIdPanierOffre(idPanierOffre);
    }

      public PanierOffreDto getById(Long idPanierOffre) {
        PanierOffre panierOffre = repo.findById(idPanierOffre).orElseThrow();
        return mapper.toDto(panierOffre);
    }


    public PanierOffre updateQuantite(Long idPanierOffre, int quantite) {
        PanierOffre panierOffre = repo.findById(idPanierOffre)
            .orElseThrow(() -> new RuntimeException("PanierOffre not found with id " + idPanierOffre));
        
        panierOffre.setQuantite(quantite);
        
        return repo.save(panierOffre);
    }
    
}
