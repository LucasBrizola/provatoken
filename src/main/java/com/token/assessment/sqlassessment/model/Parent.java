package com.token.assessment.sqlassessment.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PARENT")
public class Parent {
    @Id
    Long id;
    @Column(name = "name")
    String name;


    @OneToMany(mappedBy = "parent1")
    private Set<Child> childs1 = new HashSet<>();

    @OneToMany(mappedBy = "parent2")
    private Set<Child> childs2 = new HashSet<>();

    public Parent() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
