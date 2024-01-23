package fr.uga.miage.m1.entities;

import fr.uga.miage.m1.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "adherent")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "sequence_generator", sequenceName = "adherent_seq", allocationSize = 1)
public abstract class Adherent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    private int idAdherent;

    @Column
    private String prenom;

    @Column
    private String nom;

    enum Role {
        Conducteur, Organisateur, Festivalier
    }

    @Column
    private Role role;

    @Column
    private String mail;

    @Column
    private String telephone;

    @Column(name = "role", nullable = false, insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

}
