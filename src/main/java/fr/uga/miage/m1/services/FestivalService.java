package fr.uga.miage.m1.services;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.entities.Festival;
import fr.uga.miage.m1.entities.SousDomaine;
import fr.uga.miage.m1.mapper.FestivalMapper;
import fr.uga.miage.m1.repos.FestivalRepo;
import fr.uga.miage.m1.repos.SousDomaineRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class FestivalService {
    
    private final FestivalRepo repo;

    public Festival create(String nomManifestation) {
        Festival newFestivalEntity = new Festival();
        newFestivalEntity.setNomManifestation(nomManifestation);
        System.out.println("nomManifestation: " + newFestivalEntity.getNomManifestation());
        return repo.save(newFestivalEntity);
    }
}
