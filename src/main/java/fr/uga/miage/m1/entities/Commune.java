package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "commune")
public class Commune {

    @Id
    @Column
    private int codeInsee;

    @Column
    private double longitude;

    @Column
    private double latitude;

    @Column
    private String codePostal;

    @Column
    private String commune;

    @OneToMany
    private List<Departement> departements;

    @OneToMany
    private List<Festival> festivals;
}
