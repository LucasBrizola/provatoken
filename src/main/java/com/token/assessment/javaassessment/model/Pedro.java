package com.token.assessment.javaassessment.model;

public class Pedro extends Person {

    private final String name;

    public Pedro(){
        this.name = "Pedro";
    }

    @Override
    public String getName() {
        return this.name;
    }

}
