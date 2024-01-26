package fr.uga.miage.m1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommuneDto {
    private String codeInsee;
    private double longitude;
    private double latitude;
    private String codePostal;
    private String nomCommune;
}
