package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.OneToMany;

public class Festivalier extends Adherent {

    @OneToMany(mappedBy = "festivalier")
    List<Panier> paniers;
}
