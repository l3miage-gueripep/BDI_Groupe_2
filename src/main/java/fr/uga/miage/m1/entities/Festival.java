package fr.uga.miage.m1.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    private Double tarifPass;

    @Column
    private String codePostal;

    @ManyToOne
    @JoinColumn(name = "code_insee")
    private Commune commune;

    @OneToMany(mappedBy = "festival")
    private List<OffreCovoiturage> offreCovoiturages;

    @ManyToOne
    @JoinColumn(name = "id_adherent")
    private Adherent organisateur;

    @ManyToOne
    @JoinColumn(name = "nom_sous_domaine")
    private SousDomaine sousDomaine;

    @OneToMany(mappedBy = "festival")
    private List<LieuCovoiturage> lieuxCovoiturages;
}
