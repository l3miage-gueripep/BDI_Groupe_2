package fr.uga.miage.m1.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class PanierOffre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPanierOffre;

    @ManyToOne(optional = true)
    @JoinColumn(name = "ID_PANIER")
    private Panier panier;
    
    @ManyToOne
    private CovoiturageLieu covoiturageLieu;
    
    private int quantite;

    public Festival getFestival() {
        return this.covoiturageLieu.getOffreCovoiturage().getFestival();
    }
}
