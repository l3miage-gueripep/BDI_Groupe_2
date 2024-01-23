package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Organisateur extends Adherent {

    @OneToMany(mappedBy = "organisateur")
    private List<Festival> festivalsOrgnises;
}
