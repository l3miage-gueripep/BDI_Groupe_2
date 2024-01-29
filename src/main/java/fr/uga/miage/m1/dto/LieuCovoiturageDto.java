package fr.uga.miage.m1.dto;

import java.util.List;

import fr.uga.miage.m1.entities.CovoiturageLieu;
import fr.uga.miage.m1.entities.Festival;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
