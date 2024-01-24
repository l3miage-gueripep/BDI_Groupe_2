package fr.uga.miage.m1.services;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.entities.Festival;
import fr.uga.miage.m1.repos.FestivalRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class FestivalService {

    private final FestivalRepo repo;

    public Festival create(Festival festival) {
        // Festival newFestivalEntity = new Festival();
        // newFestivalEntity.setNomManifestation(nomManifestation);
        // System.out.println("nomManifestation: " +
        // newFestivalEntity.getNomManifestation());
        return repo.save(festival);
    }
}
