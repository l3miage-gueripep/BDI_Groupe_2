package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class PanierOffre {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_panier")
    private Panier panier;

    @Id
    @OneToMany
    private List<OffreCovoiturage> offreCovoiturages;

    @Id
    @OneToMany
    private List<LieuCovoiturage> lieuCovoiturage;
}
