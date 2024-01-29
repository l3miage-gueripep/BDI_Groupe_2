package fr.uga.miage.m1.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.entities.Panier;


public interface PanierRepo extends JpaRepository<Panier, Long>{
    
}
