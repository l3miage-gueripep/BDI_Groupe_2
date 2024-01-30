package fr.uga.miage.m1.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.entities.CovoiturageLieu;

public interface CovoiturageLieuRepo extends JpaRepository<CovoiturageLieu, Long>{
    public List<CovoiturageLieu> findByOffreCovoiturageIdOffreCovoiturage(Long idOffreCovoiturage);
}
