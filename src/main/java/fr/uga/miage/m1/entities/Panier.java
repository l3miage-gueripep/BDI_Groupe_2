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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idPanier;
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date date;
    @Column
    private double prix;
    @Column
    private int nbPieces;
    @Column
    private boolean validated;
    @ManyToMany
    private List<OffreCovoiturage> offreCovoiturages;
    @ManyToOne
    private Adherent festivalier;

}
