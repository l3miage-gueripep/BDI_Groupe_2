package fr.uga.miage.m1.services;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.entities.Domaine;
import fr.uga.miage.m1.repos.DomaineRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DomaineService {

    private final DomaineRepo repo;

    public Domaine create(Domaine domaine) {
       
        return repo.save(domaine);
    }

    
}
