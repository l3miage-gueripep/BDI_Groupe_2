package fr.uga.miage.m1.requests;

import java.sql.Date;

import fr.uga.miage.m1.Etat;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class CreatePanierRequest {
    private Long idPanier;
    private Date datePanier;
    private double prix;
    private int nbPlaces;
    private Etat etat;
    private String userMail;
}