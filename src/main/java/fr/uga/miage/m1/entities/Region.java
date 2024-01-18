package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "region")
@Getter
@Setter
public class Region {
    @Id
    @Column
    private String nomRegion;

    @OneToMany
    private List<Departement> departements;
}
