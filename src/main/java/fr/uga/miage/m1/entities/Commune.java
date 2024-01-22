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
    private int longitude;

    @Column
    private int latitude;

    @Column
    private String codePostal;

    @Column
    private String commune;

    @OneToMany(mappedBy = "commune")
    private List<Departement> departements;

    @OneToMany(mappedBy = "commune")
    private List<Festival> festivals;
}
