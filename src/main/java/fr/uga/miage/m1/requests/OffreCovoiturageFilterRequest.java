package fr.uga.miage.m1.requests;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

@Data
public class OffreCovoiturageFilterRequest {
    private Date dateDepart;
    private LocalDateTime horaireDepartMin;
    private LocalDateTime horaireDepartMax;
    private int nbPlacesMin;
}
