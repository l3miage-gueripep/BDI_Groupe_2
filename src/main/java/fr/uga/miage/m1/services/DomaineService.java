package fr.uga.miage.m1.services;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.entities.Domaine;
import fr.uga.miage.m1.mapper.DomaineMapper;
import fr.uga.miage.m1.repos.DomaineRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DomaineService {

    private final DomaineRepo repo;

    public Domaine create(String nomDomaine) {
        Domaine newDomaineEntity = new Domaine();
        newDomaineEntity.setNomDomaine(nomDomaine);
        System.out.println("nomDomaine: " + newDomaineEntity.getNomDomaine());
        return repo.save(newDomaineEntity);
    }
}
