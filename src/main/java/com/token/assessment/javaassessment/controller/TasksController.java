package com.token.assessment.javaassessment.controller;

import com.token.assessment.javaassessment.model.Person;
import com.token.assessment.javaassessment.model.PersonFactory;
import com.token.assessment.javaassessment.service.TasksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    public Person[] createArrayFromStrings(String[] names) {
        Person[] namesArray = new Person[names.length];
        int i = 0;
        for (String name : names) {
            namesArray[i] = PersonFactory.createPerson(name);
            i++;
        }
        return namesArray;
    }

    @Operation(summary = "return another array of Object on reversed order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "names reversed with success",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Person[].class))}),
            @ApiResponse(responseCode = "400", description = "invalid body, body must be as follows: [\"name1\",\"name2\"]")})
    @GetMapping(value = "/task1")
    public ResponseEntity<Person[]> task1(@Parameter(description = "String Array of names, Valid names: Lucas, Matheus, Pedro, Paulo", example = "[\"Lucas\",\"Matheus\"]") @RequestBody String[] names) {
        Person[] namesArray = createArrayFromStrings(names);
        Person[] namesReversed = tasksService.reverseNewArray(namesArray);
        return new ResponseEntity<>(namesReversed, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "return same array of Object on reversed order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "names reversed with success",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Person[].class))}),
            @ApiResponse(responseCode = "400", description = "invalid body, body must be as follows: [\"name1\",\"name2\"]")})
    @GetMapping(value = "/task2")
    public ResponseEntity<Person[]> task2(@Parameter(description = "String Array of names, Valid names: Lucas, Matheus, Pedro, Paulo", example = "[\"Lucas\",\"Matheus\"]") @RequestBody String[] names) {
        Person[] namesArray = createArrayFromStrings(names);
        Person[] namesReversed = tasksService.reverseSameArray(namesArray);
        return new ResponseEntity<>(namesReversed, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "return List of Object on reversed order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "names reversed with success",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String[].class))}),
            @ApiResponse(responseCode = "400", description = "invalid body, body must be as follows: [\"name1\",\"name2\"]")})
    @GetMapping(value = "/task3")
    public ResponseEntity<List<Person>> task3(@Parameter(description = "String Array of names, Valid names: Lucas, Matheus, Pedro, Paulo", example = "[\"Lucas\",\"Matheus\"]") @RequestBody String[] names) {
        Person[] namesArray = createArrayFromStrings(names);
        List<Person> namesReversed = tasksService.reverseList(Arrays.asList(namesArray));
        return new ResponseEntity<>(namesReversed, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "return Array of String from a csv file")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "file read success",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String[].class))})})
    @GetMapping(value = "/task4")
    public ResponseEntity<String[]> task4() {
        String[] names = tasksService.readFile();
        return new ResponseEntity<>(names, HttpStatus.ACCEPTED);
    }
}
