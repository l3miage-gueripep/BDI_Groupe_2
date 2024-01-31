package fr.uga.miage.m1.repos;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.Etat;
import fr.uga.miage.m1.entities.Panier;


public interface PanierRepo extends JpaRepository<Panier, Long>{
    public Optional<Panier> findByAdherentMailAndEtat(String mail, Etat etat);
}
