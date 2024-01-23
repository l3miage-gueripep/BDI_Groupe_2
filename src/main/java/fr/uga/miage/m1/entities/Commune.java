package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "commune")
public class Commune {

    @Id
    @Column
    private String codeInsee;

    @Column
    private double longitude;

    @Column
    private double latitude;

    @Column
    private String nomCommune;

    @OneToMany
    private List<Departement> departements;

    @OneToMany(mappedBy = "commune")
    private List<Festival> festivals;
}
