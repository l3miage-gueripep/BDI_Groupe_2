package fr.uga.miage.m1.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.entities.Panier;
import fr.uga.miage.m1.entities.PanierOffre;

public interface PanierOffreRepo extends JpaRepository<PanierOffre, Long> {
    void deleteByIdPanierOffre(Long idPanierOffre);
}
