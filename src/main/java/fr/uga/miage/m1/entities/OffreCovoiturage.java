package fr.uga.miage.m1.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "offre_covoiturage")
@Getter
@Setter
public class OffreCovoiturage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idOffreCovoiturage;
    @Column
    private String modeleVoiture;
    @Column
    private int nbPlaces;
    @Column
    private double prixCovoiturage;

    @ManyToOne
    @JoinColumn(name = "id_adherent")
    private Conducteur conducteur;

    @ManyToOne
    @JoinColumn(name = "nom_manifestation")
    private Festival festival;

    @ManyToOne
    private PanierOffre panierOffre;

}
