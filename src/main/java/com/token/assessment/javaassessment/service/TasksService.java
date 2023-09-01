package com.token.assessment.javaassessment.service;

import com.token.assessment.javaassessment.model.Person;
import org.springframework.stereotype.Service;

@Service
public class TasksService {
    public Person[] reverseNewArray(Person[] names) {
        Person[] namesReversed = new Person[names.length];
        int namesSize = names.length -1 ;
        int j = 0;
        for (int i = namesSize; i >= 0; i--) {
            namesReversed[j] = names[i];
            j++;
        }

        return namesReversed;
    }
}
