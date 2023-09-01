package com.token.assessment.javaassessment.service;

import com.token.assessment.javaassessment.model.Person;
import com.token.assessment.javaassessment.model.PersonFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class TasksTest {
    static Person person1;
    static Person person2;
    static Person person3;
    static Person person4;
    static TasksService tasks;
    @BeforeAll
    public static void setup(){
        person1 =  PersonFactory.createPerson("Lucas");
        person2 =  PersonFactory.createPerson("Matheus");
        person3 =  PersonFactory.createPerson("Pedro");
        person4 =  PersonFactory.createPerson("Paulo");
        tasks = new TasksService();
    }
    @Test
    @DisplayName("receiveArrayAndReturnAnotherReversed")
    public void shouldReceiveAnArrayAndReturnAnotherReversed(){
        Person[] names = { person1, person2, person3, person4};
        Person[] namesReversed = {person4, person3, person2, person1};

        Person[] namesReturned = tasks.reverseNewArray(names);

        Assertions.assertArrayEquals(namesReturned,namesReversed);

    }

    @Test
    @DisplayName("receiveArrayAndReturnSameReversed")
    public void shouldReceiveAnArrayAndReturnSameReversed(){
        Person[] names = { person1, person2, person3, person4};
        Person[] namesReversed = {person4, person3, person2, person1};

        Person[] namesReturned = tasks.reverseSameArray(names);

        Assertions.assertArrayEquals(namesReturned,namesReversed);

    }

    @Test
    @DisplayName("receiveListAndReturnSameReversed")
    public void shouldReceiveAListAndReturnSameReversed(){
        List<Person> names = Arrays.asList( person1, person2, person3, person4);
        List<Person> namesReversed = Arrays.asList( person4, person3, person2, person1);

        List<Person> namesReturned = tasks.reverseList(names);

        Assertions.assertIterableEquals(namesReturned,namesReversed);

    }

    @Test
    @DisplayName("receiveListAndReturnSameManualReversed")
    public void shouldReceiveAListAndReturnSameManualReversed(){
        //Arrays.asList are unmodifiable (no add or remove), so LinkedList was needed
        List<Person> names = new LinkedList<>((Arrays.asList( person1, person2, person3, person4)));
        List<Person> namesReversed = Arrays.asList( person4, person3, person2, person1);

        List<Person> namesReturned = tasks.manualReverseList(names);

        Assertions.assertIterableEquals(namesReturned,namesReversed);

    }

    @Test
    @DisplayName("shouldReceiveACsvFile")
    public void shouldReceiveACsvFile(){
        String[] namesReturned = tasks.readFile();
        String[] names = {person1.getName(), person2.getName(), person3.getName(), person4.getName()};

        Assertions.assertArrayEquals(namesReturned, names);
    }
}
