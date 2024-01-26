package fr.uga.miage.m1.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.entities.Commune;

public interface CommuneRepository extends JpaRepository<Commune, String> {
    List<Commune> findByNomCommuneContainingIgnoreCase(String nomCommune);
}
