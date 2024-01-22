package fr.uga.miage.m1.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Festival {

    @Id
    @Column
    private String nomManifestation;

    @Column
    private String siteWeb;

    @Column
    private String lieuPrincipal;

    @Column
    private Date dateDebut;

    @Column
    private Date dateFin;

    @Column
    private double tarifPass;

    @ManyToOne
    private Commune commune;

    @OneToMany
    private List<Panier> paniers;

    @OneToMany(mappedBy = "festival")
    private List<OffreCovoiturage> offreCovoiturages;

    @ManyToOne
    private Adherent organisateur;

    @ManyToOne
    private SousDomaine sousDomaine;
}
