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
    @Column
    private double prixCovoiturage;
    @ManyToMany
    private List<Panier> paniers;
    @ManyToOne
    private Adherent conducteur;
    @ManyToOne
    private Festival festival;
    @OneToMany
    private List<LieuCovoiturage> lieusCovoiturage;
}
