package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("CONDUCTEUR")
public class Conducteur extends Adherent {

    @OneToMany(mappedBy = "conducteur")
    private List<OffreCovoiturage> offresCovoiturage;
}
