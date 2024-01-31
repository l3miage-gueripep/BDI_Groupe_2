package fr.uga.miage.m1.dto;

import lombok.Data;

@Data
public class PanierOffreDto {
    private Long idPanierOffre;
    private int quantite;
    private FestivalDto festival;
    private CovoiturageLieuDto covoiturageLieu;
}
