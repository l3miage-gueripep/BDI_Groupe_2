package fr.uga.miage.m1.entities;

import java.util.List;

import fr.uga.miage.m1.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "adherent")
public class Adherent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test")
    @SequenceGenerator(name = "test", allocationSize = 1, initialValue = 20095)
    private Integer idAdherent;

    @Column
    private String prenom;

    @Column
    private String nom;

    @Column
    private String mail;

    @Column
    private String telephone;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "adherent")
    List<Panier> paniers;
}
