package fr.uga.miage.m1.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FestivalDto {

    private String nomManifestation;
    private String siteWeb;
    private Date dateDebut;
    private Date dateFin;
    private double tarifPass;
    private String codePostal;
    private String lieuPrincipal;
    // Getters et Setters
    // ...
}