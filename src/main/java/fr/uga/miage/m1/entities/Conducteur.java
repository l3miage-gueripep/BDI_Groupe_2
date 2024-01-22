package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.OneToMany;

public class Conducteur extends Adherent {

    @OneToMany(mappedBy = "conducteur")
    private List<OffreCovoiturage> offresCovoiturage;
}
