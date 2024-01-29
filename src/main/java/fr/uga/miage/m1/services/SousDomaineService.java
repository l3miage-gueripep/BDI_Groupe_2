package fr.uga.miage.m1.services;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.entities.SousDomaine;
import fr.uga.miage.m1.repos.SousDomaineRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class SousDomaineService {

    private final SousDomaineRepo repo;

    public SousDomaine create(SousDomaine sousDomaine) {
        return repo.save(sousDomaine);
    }
}
