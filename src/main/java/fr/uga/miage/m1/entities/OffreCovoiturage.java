package fr.uga.miage.m1.entities;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "id_adherent")
    private Adherent adherent;

    @ManyToOne
    @JoinColumn(name = "nom_manifestation")
    private Festival festival;

    @ManyToOne
    private PanierOffre panierOffre;

    @ManyToMany
    private List<CovoiturageLieu> covoiturageLieux;

}
