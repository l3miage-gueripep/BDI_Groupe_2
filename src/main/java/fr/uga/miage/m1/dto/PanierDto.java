package fr.uga.miage.m1.dto;

import java.util.Date;
import java.util.List;

import fr.uga.miage.m1.Etat;
import fr.uga.miage.m1.entities.CovoiturageLieu;
import fr.uga.miage.m1.entities.PanierOffre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PanierDto {
    private Long idPanier;
    private Date datePanier;
    private double prix;
    private int nbPlaces;
    private Etat etat;
    private List<CovoiturageLieuDto> covoiturageLieux;
}
