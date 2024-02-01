package fr.uga.miage.m1.requests;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OffreCovoiturageFilterRequest {
    private LocalDateTime horaireDepartMin;
    private LocalDateTime horaireDepartMax;
    private int nbPlacesMin;
}
