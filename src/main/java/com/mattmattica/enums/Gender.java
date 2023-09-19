package com.mattmattica.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Gender {
    MALE(1, "Male"),
    FEMALE(2, "Female"),
    PREFER_NOT_TO_SAY(3, "Prefer Not To Say");

    private int id;
    private String name;

    private static final Gender[] GENDERS = values();
    private static final Map<String, Gender> NAME_TO_GENDER = Arrays.stream(GENDERS).collect(Collectors.toUnmodifiableMap(Gender::getName, self->self));
    private static final Map<Integer, Gender> ID_TO_GENDER = Arrays.stream(GENDERS).collect(Collectors.toUnmodifiableMap(Gender::getId, self->self));

    Gender(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Gender ofName(String name) {
        return NAME_TO_GENDER.get(name);
    }

    public static Gender ofId(Integer id) {
        return ID_TO_GENDER.get(id);
    }
}
