package fr.uga.miage.m1.entities;

import java.util.Date;
import java.util.List;

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
    private int nbPieces;
    @Column
    private Boolean validated;
    @ManyToMany
    private List<OffreCovoiturage> offresCovoiturage;
    @ManyToOne
    private Adherent festivalier;
}
