package fr.uga.miage.m1.requests;

import lombok.Data;

@Data
public class AddPanierOffreRequest {
    String userMail;
    Long idCovoiturageLieu;
    int quantite;
}
