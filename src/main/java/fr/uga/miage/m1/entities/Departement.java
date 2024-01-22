package fr.uga.miage.m1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "departement")
public class Departement {

    @Id
    @Column
    private int numDepartement;

    @Column
    private String nomDepartement;

    @ManyToOne
    private Region region;
}
