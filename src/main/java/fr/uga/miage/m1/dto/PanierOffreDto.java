package fr.uga.miage.m1.dto;

import java.util.List;

import lombok.Data;

@Data
public class PanierOffreDto {
    private Long idPanierOffre;
    private FestivalDto festival;
    private List<CovoiturageLieuDto> covoiturageLieux;
}
