package com.token.assessment.javaassessment.controller;

import com.token.assessment.javaassessment.model.Person;
import com.token.assessment.javaassessment.model.PersonFactory;
import com.token.assessment.javaassessment.service.TasksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    public Person[] createArrayFromStrings(String[] names){
        Person[] namesArray = new Person[names.length];
        int i = 0;
        for (String name : names) {
            namesArray[i] = PersonFactory.createPerson(name);
            i++;
        }
        return namesArray;
    }

    @GetMapping(value = "/task1")
    public ResponseEntity<Person[]> task1(@RequestBody String[] names) {
        Person[] namesArray = createArrayFromStrings(names);
        Person[] namesReversed = tasksService.reverseNewArray(namesArray);
        return new ResponseEntity<>(namesReversed, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/task2")
    public ResponseEntity<Person[]> task2(@RequestBody String[] names) {
        Person[] namesArray = createArrayFromStrings(names);
        Person[] namesReversed = tasksService.reverseSameArray(namesArray);
        return new ResponseEntity<>(namesReversed, HttpStatus.ACCEPTED);
    }
}
