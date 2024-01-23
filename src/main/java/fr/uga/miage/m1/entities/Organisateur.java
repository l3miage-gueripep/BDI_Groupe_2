package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("ORGANISATEUR")
public class Organisateur extends Adherent {

    @OneToMany(mappedBy = "organisateur")
    private List<Festival> festivalsOrgnises;
}
