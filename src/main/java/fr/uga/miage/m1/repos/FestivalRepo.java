package fr.uga.miage.m1.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.entities.Domaine;
import fr.uga.miage.m1.entities.Festival;
public interface FestivalRepo  extends JpaRepository<Festival, String>{
    
}
