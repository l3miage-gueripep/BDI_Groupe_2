package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sous_domaine")
@Getter
@Setter
public class SousDomaine {
    @Id
    @Column
    private String nomSousDomaine;
    @ManyToOne
    private Domaine domaine;
    @OneToMany
    private List<Festival> festivals;
}
