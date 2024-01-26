package fr.uga.miage.m1.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.uga.miage.m1.entities.Adherent;
import fr.uga.miage.m1.entities.Festivalier;

@Repository
public interface FestivalierRepo extends JpaRepository<Festivalier, Integer>{
    
}
