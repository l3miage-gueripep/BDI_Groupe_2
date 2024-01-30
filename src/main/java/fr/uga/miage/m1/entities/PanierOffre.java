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
    
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "panieroffre_covoituragelieu",
        joinColumns = @JoinColumn(name = "panieroffre_id")
    )
    private List<CovoiturageLieu> covoiturageLieux = new ArrayList<>();

    public Festival getFestival() {
        if(this.covoiturageLieux.isEmpty())
            return null;
        return this.covoiturageLieux.get(0).getOffreCovoiturage().getFestival();
    }
}
