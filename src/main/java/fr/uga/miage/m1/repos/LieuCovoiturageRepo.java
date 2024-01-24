package fr.uga.miage.m1.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.entities.LieuCovoiturage;

public interface LieuCovoiturageRepo extends JpaRepository<LieuCovoiturage, String> {

}
