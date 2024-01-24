package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sous_domaine")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SousDomaine {
    @Id
    @Column
    private String nomSousDomaine;

    @OneToMany(mappedBy = "sousDomaine")
    private List<Festival> festivals;

    @ManyToOne
    private Domaine domaine;

    public SousDomaine(String nomSousDomaine, Domaine domaine) {
        this.nomSousDomaine = nomSousDomaine;
        this.domaine = domaine;
    }
}
