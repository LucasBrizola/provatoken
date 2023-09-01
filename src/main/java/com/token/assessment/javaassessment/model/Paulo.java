package com.token.assessment.javaassessment.model;

public class Paulo extends Person {

    private final String name;

    public Paulo(){
        this.name = "Paulo";
    }

    @Override
    public String getName() {
        return this.name;
    }

}
