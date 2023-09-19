package com.mattmattica.entities;

import com.mattmattica.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
