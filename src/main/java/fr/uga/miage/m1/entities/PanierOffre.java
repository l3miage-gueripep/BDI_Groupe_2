package fr.uga.miage.m1.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class PanierOffre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_panier")
    private Panier panier;

    @OneToMany(mappedBy = "panierOffre")
    private List<OffreCovoiturage> covoiturages;

    @OneToMany(mappedBy = "panierOffre")
    private List<LieuCovoiturage> lieux;
}