package fr.uga.miage.m1.entities;

import java.util.Date;
import java.util.List;

import fr.uga.miage.m1.Etat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "panier")
@Getter
@Setter
public class Panier {
    @Id
    @GeneratedValue
    @Column
    private Long idPanier;
    @Column
    private Date datePanier;
    @Column
    private double prix;
    @Column
    private int nbPlaces;
    @Column
    private Etat etat;
    @ManyToMany
    private List<OffreCovoiturage> offresCovoiturage;

    @ManyToOne
    @JoinColumn(name = "festivalier_panier")
    private Festivalier festivalier;
}
