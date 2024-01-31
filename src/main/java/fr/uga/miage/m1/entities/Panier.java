package fr.uga.miage.m1.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.uga.miage.m1.Etat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "panier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Panier {
    @Id
    @GeneratedValue
    @Column
    private Long idPanier;

    @Column
    private Date datePanier;
    
    @Column
    private Etat etat;


    @ManyToOne
    @JoinColumn(name = "id_adherent")
    private Adherent adherent;

    @OneToMany(mappedBy = "panier")
    @Builder.Default
    private List<PanierOffre> panierOffres = new ArrayList<>();
}
