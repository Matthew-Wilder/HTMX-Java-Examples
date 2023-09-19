package com.mattmattica.entities;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.util.Objects;


@MappedSuperclass
public abstract class EntityI32 implements Serializable {

    /**
     * Unique primary key used by sub-entities.
     * Not final because JPA may need a noArgsConstructor
     * and will use setters after construction
     * Long to prevent id clashing
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Compared this object with the parameter. Only returns true if they are
     * the exact same class and have matching IDs (primary key). Hence, it
     * will not return true if the IDs are identical but the classes are different.
     *
     * @param o Object to compare with
     * @return whether or not the objects are in the same table and have the same id
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityI32 that = (EntityI32) o;
        return Objects.equals(this.id, that.id);
    }


    /**
     * hashCodes will be equal if and only if the objects are
     * equal according to {@link #equals} This is a suggestion
     * from  {@link Object#hashCode} to allow hash tables to
     * function properly
     *
     * @return hashCode of this
     */
    @Override
    public int hashCode() {
        // include #getClass to stop subclasses from
        // unintentionally having equal hashes
        return Objects.hash(id, getClass());
    }

}
