package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @ManyToOne
    @JoinColumn(name = "id_panier")
    private Panier panier;

    @ManyToMany(mappedBy = "panierOffre")
    private List<CovoiturageLieu> covoiturageLieux;

    public Festival getFestival() {
        return this.covoiturageLieux.get(0).getOffreCovoiturage().getFestival();
    }
}
