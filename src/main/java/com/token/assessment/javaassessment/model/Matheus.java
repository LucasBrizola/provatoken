package com.token.assessment.javaassessment.model;

public class Matheus extends Person {

    private final String name;

    public Matheus(){
        this.name = "Matheus";
    }

    @Override
    public String getName() {
        return this.name;
    }

}
