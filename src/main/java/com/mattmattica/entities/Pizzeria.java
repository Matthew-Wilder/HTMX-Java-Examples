package com.mattmattica.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="pizzeria")
public class Pizzeria extends EntityI32 {

    @Column(name = "name", unique = true)
    private String name;


    @ManyToMany(mappedBy = "frequentedPizzerias", fetch = FetchType.LAZY)
    private Set<Person> regulars = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "serves",
            joinColumns = @JoinColumn(name = "pizzeria_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id")
    )
    private Set<Pizza> pizzasServed = new HashSet<>();

}
