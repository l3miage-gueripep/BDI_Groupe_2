package fr.uga.miage.m1.services;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.entities.Commune;
import fr.uga.miage.m1.repos.CommuneRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommuneService {

    private final CommuneRepository communeRepository;

    public Commune create(Commune commune) {
        return communeRepository.save(commune);
    }
}
