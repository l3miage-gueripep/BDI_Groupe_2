package fr.uga.miage.m1.dto;

import java.util.Date;
import java.util.List;

import fr.uga.miage.m1.Etat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PanierDto {
    private Long idPanier;
    private Date datePanier;
    private Etat etat;
    private String userMail;
    private List<PanierOffreDto> panierOffres;
}
