package fr.uga.miage.m1.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
@Table(name = "adherent")
public class Adherent {

    @Id
    @GeneratedValue
    @Column
    private int idAdhérent;

    @Column
    private String prenom;

    @Column
    private String nom;

    @Column
    private String mail;

    @Column
    private String telephone;

    @OneToMany
    private List<Festival> festivalsOrganise;

    @OneToMany
    private List<OffreCovoiturage> offreCovoiturages;

}
