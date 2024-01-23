package fr.uga.miage.m1.repos;

import java.util.Optional;

import fr.uga.miage.m1.entities.Commune;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommuneRepository {

    private final AbstractRepository abstractRepository;

    public Commune getCommune(String nomCommune) {
        Optional<Commune> communeResult = abstractRepository.findById(nomCommune);
        if (communeResult.isPresent()) {
            return communeResult.get();
        } else {
            throw new EntityExistsException("Aucune commune de ce nom n'est present dans la base");
        }
    }

}
