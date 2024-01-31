package fr.uga.miage.m1.requests;

import lombok.Data;

@Data
public class AddPanierOffreRequest {
    Long idPanier;
    Long idCovoiturageLieu;
    int quantite;
}
