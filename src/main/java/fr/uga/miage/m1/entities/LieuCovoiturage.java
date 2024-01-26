package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lieu_covoiturage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LieuCovoiturage {
    @Id
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
