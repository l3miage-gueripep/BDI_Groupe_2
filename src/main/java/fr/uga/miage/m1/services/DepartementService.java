package fr.uga.miage.m1.services;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.entities.Departement;
import fr.uga.miage.m1.repos.DepartementRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartementService {

    private final DepartementRepo repo;

    public Departement create(Departement departement) {

        return repo.save(departement);
    }
}
