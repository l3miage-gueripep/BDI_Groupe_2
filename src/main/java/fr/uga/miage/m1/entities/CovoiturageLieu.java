package fr.uga.miage.m1.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "covoiturage_lieu")
public class CovoiturageLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCovoiturageLieu;

    @ManyToOne
    @JoinColumn(name = "id_covoiturage")
    private OffreCovoiturage offreCovoiturage;

    @ManyToOne
    @JoinColumn(name = "id_lieu")
    private LieuCovoiturage lieuCovoiturage;

    @ManyToMany
    private PanierOffre panierOffre;

    private LocalDateTime horaire;

    private double prix;
}
