package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;

@Entity
@Getter
public class PanierOffre {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_panier")
    private Panier panier;

    @ManyToMany
    private List<CovoiturageLieu> covoiturageLieux;
}
