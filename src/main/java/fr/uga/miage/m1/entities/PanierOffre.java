package fr.uga.miage.m1.entities;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class PanierOffre {

    @Id
    @ManyToOne
    @JoinColumn(name = "panier_id")
    private Long idPaiement;

    @Id
    @OneToMany
    private Long idCovoiturage;

    @Id
    @OneToMany
    private String idLieu;
}
