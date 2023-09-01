package com.token.assessment.sqlassessment.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CHILD")
public class Child {
    @Id
    Long id;
    @Column(name = "name")
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @Nullable
    @JoinColumn(name = "father_id", referencedColumnName = "ID")
    private Parent parent1;

    @ManyToOne(fetch = FetchType.LAZY)
    @Nullable
    @JoinColumn(name = "mother_id", referencedColumnName = "ID")
    private Parent parent2;

    public Child() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
