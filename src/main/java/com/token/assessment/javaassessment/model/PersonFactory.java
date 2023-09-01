package com.token.assessment.javaassessment.model;

public class PersonFactory {
    
    public static Person createPerson(String name){
        if("Lucas".equalsIgnoreCase(name)) return new Lucas();
        else if ("Matheus".equalsIgnoreCase(name)) return new Matheus();
        else if ("Pedro".equalsIgnoreCase(name)) return new Pedro();
        else if ("Paulo".equalsIgnoreCase(name)) return new Paulo();
        else
        return null;
    }
}
