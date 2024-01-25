package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sous_domaine")
@Getter
@Setter
@Builder
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
}
