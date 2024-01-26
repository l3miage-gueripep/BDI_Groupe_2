package fr.uga.miage.m1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OffreCovoiturageDto {
    private Long idOffreCovoiturage;
    private String modeleVoiture;
    private int nbPlaces;
    private double prixCovoiturage;
    // private Conducteur conducteur;
    // private Festival festival;
    // private PanierOffre panierOffre;
}