package fr.uga.miage.m1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table
@Getter
@IdClass(PersonId.class)
public final class Person {
    @Id
    @Column(name="first_name")
    private String firstName;
    @Id
    @Column(name="last_name")
    private String lastName;
}
