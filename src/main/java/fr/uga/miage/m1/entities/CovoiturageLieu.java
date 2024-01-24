package fr.uga.miage.m1.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @ManyToOne
    @JoinColumn(name = "id_covoiturage")
    private OffreCovoiturage offreCovoiturage;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_lieu")
    private LieuCovoiturage lieuCovoiturage;

    private LocalDateTime horaire;

    private double prix;
}
