package fr.uga.miage.m1.requests;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CreateCovoiturageLieuRequest {
    private Long idOffreCovoiturage;
    private String idLieuCovoiturage;
    private LocalDateTime horaire;
    private Double prix;
}

