package fr.uga.miage.m1.requests;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@Builder
public class FestivalFilterRequest {
    private String lieuPrincipal;
    private String nomManifestation;
    private String sousDomaine;
    private Date dateDebut;
    private Date dateFin;
}
