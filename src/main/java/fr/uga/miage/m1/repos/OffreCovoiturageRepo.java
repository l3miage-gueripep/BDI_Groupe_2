package fr.uga.miage.m1.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.uga.miage.m1.entities.OffreCovoiturage;

@Repository
public interface OffreCovoiturageRepo extends JpaRepository<OffreCovoiturage, Long>{
    Page<OffreCovoiturage> findAllByFestival(Pageable pageable, String nomManifestation);

}
