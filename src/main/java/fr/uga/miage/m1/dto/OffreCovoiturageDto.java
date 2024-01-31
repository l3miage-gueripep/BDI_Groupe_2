package fr.uga.miage.m1.dto;

import java.util.Date;
import java.util.List;

import fr.uga.miage.m1.entities.Festival;
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
    private AdherentDto conducteur;
}