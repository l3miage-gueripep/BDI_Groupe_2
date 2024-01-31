package fr.uga.miage.m1.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCovoiturageLieu;

    @ManyToOne
    @JoinColumn(name = "id_covoiturage")
    private OffreCovoiturage offreCovoiturage;

    @ManyToOne
    @JoinColumn(name = "id_lieu")
    private LieuCovoiturage lieuCovoiturage;

    @OneToMany(mappedBy = "covoiturageLieu", cascade = CascadeType.ALL)
    private List<PanierOffre> panierOffres = new ArrayList<>();

    private LocalDateTime horaire;

    private double prix;
}
