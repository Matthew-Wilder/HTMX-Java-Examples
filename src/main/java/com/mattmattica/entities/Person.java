package com.mattmattica.entities;

import com.mattmattica.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="person")
public class Person extends EntityI32 {

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender_id")
    private Gender gender;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "eats",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id")
    )
    private Set<Pizza> pizzasEaten = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "frequents",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "pizzeria_id")
    )
    private Set<Pizzeria> frequentedPizzerias = new HashSet<>();



}
