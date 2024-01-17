package fr.uga.miage.m1.entities;
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
    private Long idLieu;

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
    private Festival festival;
}
