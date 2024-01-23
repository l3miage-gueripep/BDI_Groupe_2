package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Festivalier extends Adherent {

    @OneToMany(mappedBy = "festivalier")
    List<Panier> paniers;
}
