package fr.uga.miage.m1.services;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.entities.SousDomaine;
import fr.uga.miage.m1.mapper.SousDomaineMapper;
import fr.uga.miage.m1.repos.SousDomaineRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class SousDomaineService {
    
    private final SousDomaineRepo repo;

    public SousDomaine create(String nomSousDomaine) {
        SousDomaine newSousDomaineEntity = new SousDomaine();
        newSousDomaineEntity.setNomSousDomaine(nomSousDomaine);
        System.out.println("nomSousDomaine: " + newSousDomaineEntity.getNomSousDomaine());
        return repo.save(newSousDomaineEntity);
    }
}
