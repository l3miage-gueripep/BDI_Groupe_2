package fr.uga.miage.m1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jxl.write.DateTime;
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
    @JoinColumn(name = "offreCovoiturage_id")
    private Long idCovoiturage;

    @Id
    @ManyToOne
    @JoinColumn(name = "lieuCovoiturage_id")
    private String idLieu;

    private DateTime horaire;

    private double prix;

    @ManyToOne
    private OffreCovoiturage offreCovoiturage;

    @ManyToOne
    private LieuCovoiturage lieuCovoiturage;

}
