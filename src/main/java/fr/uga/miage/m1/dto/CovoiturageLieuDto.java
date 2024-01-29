package fr.uga.miage.m1.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CovoiturageLieuDto {
    private OffreCovoiturageDto offreCovoiturage;
    private LieuCovoiturageDto lieuCovoiturage;
    private LocalDateTime horaire;
    private double prix;
}
