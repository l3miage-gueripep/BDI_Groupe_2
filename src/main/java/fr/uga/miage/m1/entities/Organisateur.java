package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.OneToMany;

public class Organisateur extends Adherent {

    @OneToMany(mappedBy = "organisateur")
    private List<Festival> festivalsOrgnises;
}
