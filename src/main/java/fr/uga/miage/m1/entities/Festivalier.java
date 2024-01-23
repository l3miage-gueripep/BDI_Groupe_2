package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("FESTIVALIER")
public class Festivalier extends Adherent {

    @OneToMany(mappedBy = "festivalier")
    List<Panier> paniers;
}
