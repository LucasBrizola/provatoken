package com.token.assessment.javaassessment.service;

import com.token.assessment.javaassessment.model.Person;
import com.token.assessment.javaassessment.model.PersonFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TasksTest {
    @Test
    @DisplayName("receiveArrayOfObjects")
    public void shouldReceiveAnArrayAndReturnAnotherReversed(){
        Person person1 =  PersonFactory.createPerson("Lucas");
        Person person2 =  PersonFactory.createPerson("Matheus");
        Person person3 =  PersonFactory.createPerson("Pedro");
        Person person4 =  PersonFactory.createPerson("Paulo");

        Person[] names = new Person[4];
        names[0] = person1;
        names[1] = person2;
        names[2] = person3;
        names[3] = person4;

        Person[] namesReversed = new Person[4];
        namesReversed[0] = person4;
        namesReversed[1] = person3;
        namesReversed[2] = person2;
        namesReversed[3] = person1;
        TasksService task1 = new TasksService();
        Person[] namesReturned = task1.reverseNewArray(names);

        Assertions.assertArrayEquals(namesReturned,namesReversed);

    }
}
