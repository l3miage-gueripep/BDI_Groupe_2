package fr.uga.miage.m1.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.entities.Departement;
import fr.uga.miage.m1.entities.Domaine;
public interface DepartementRepo  extends JpaRepository<Departement, String>{
    
}
