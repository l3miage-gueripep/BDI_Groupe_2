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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_panier")
    private Long idPanier;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", columnDefinition = "TIMESTAMP")
    private Date date;
    @Column
    private double prix;
    @Column
    private int nbPieces;
    @Column(name = "validated", columnDefinition = "NUMBER(1)")
    private Boolean validated;
    // @ManyToMany
    // private List<OffreCovoiturage> offreCovoiturages;
    /*
     * @ManyToOne
     * 
     * @JoinColumn(name = "festivalier_id_adherent")
     * private Adherent festivalier;
     */

}
