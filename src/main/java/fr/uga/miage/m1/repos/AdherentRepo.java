package fr.uga.miage.m1.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.uga.miage.m1.entities.Adherent;

@Repository
public interface AdherentRepo  extends JpaRepository<Adherent, Integer>{
    
}
