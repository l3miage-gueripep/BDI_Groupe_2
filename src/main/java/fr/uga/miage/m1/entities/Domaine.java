package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.annotation.Nullable;
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
@Table(name = "domaine")
public class Domaine {

    @Id
    private String nomDomaine;

    @OneToMany
    @Nullable
    private List<SousDomaine> sousDomaine;

    public Domaine(String domaine) {
        this.nomDomaine = domaine;
        this.sousDomaine = new java.util.ArrayList<>();
    }
}
