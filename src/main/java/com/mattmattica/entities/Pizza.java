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
@Table(name="pizza")
public class Pizza extends EntityI32 {

    @Column(name = "name", unique = true)
    private String name;

    @ManyToMany(mappedBy = "pizzasEaten", fetch = FetchType.LAZY)
    private Set<Person> eatenBy = new HashSet<>();

    @ManyToMany(mappedBy = "pizzasServed", fetch = FetchType.LAZY)
    private Set<Pizzeria> pizzeriasServedAt = new HashSet<>();
}
