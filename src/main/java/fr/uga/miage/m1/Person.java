package fr.uga.miage.m1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

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
