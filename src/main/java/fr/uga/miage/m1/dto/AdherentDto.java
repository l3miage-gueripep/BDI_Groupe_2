package fr.uga.miage.m1.dto;

import fr.uga.miage.m1.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdherentDto {
    private int idAdherent;
    private String prenom;
    private String nom;
    private String mail;
    private String telephone;
    private Role role;
}
