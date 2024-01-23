package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lieu_covoiturage")
@Getter
@Setter
public class LieuCovoiturage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private String idLieu;

    @Column
    private String nomLieu;

    @Column
    private String adresseLieu;

    @Column
    private String typeLieu;

    @Column
    private double longitude;

    @Column
    private double latitude;

    @ManyToOne
    @JoinColumn(name = "nom_manifestation")
    private Festival festival;

    @OneToMany(mappedBy = "lieuCovoiturage")
    private List<CovoiturageLieu> covoiturageLieu;
}
