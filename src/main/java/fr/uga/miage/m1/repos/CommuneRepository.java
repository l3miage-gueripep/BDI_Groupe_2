package fr.uga.miage.m1.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.entities.Commune;

public interface CommuneRepository extends JpaRepository<Commune, String> {

}
