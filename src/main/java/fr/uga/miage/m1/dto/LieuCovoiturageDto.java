package fr.uga.miage.m1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LieuCovoiturageDto {
    private String idLieu;
    private String nomLieu;
    private String adresseLieu;
    private String typeLieu;
    private double longitude;
    private double latitude;
}
