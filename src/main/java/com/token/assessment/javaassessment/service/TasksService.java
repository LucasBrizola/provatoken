package com.token.assessment.javaassessment.service;

import com.token.assessment.javaassessment.model.Person;
import org.springframework.stereotype.Service;

@Service
public class TasksService {
    public Person[] reverseNewArray(Person[] names) {
        Person[] namesReversed = new Person[names.length];
        int namesSize = names.length - 1;
        int j = 0;
        for (int i = namesSize; i >= 0; i--) {
            namesReversed[j] = names[i];
            j++;
        }

        return namesReversed;
    }

    public Person[] reverseSameArray(Person[] names) {
        Person name;
        int last = names.length;
        for (int i = 0; i < last / 2; i++) {
            name = names[i];
            names[i] = names[last - i -1];
            names[last - i - 1] = name;
        }

        return names;
    }
}
