package com.token.assessment.sqlassessment.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class SqlTest {

    @Autowired
    private SqlService sqlService;

    @BeforeAll
    public static void setup() {

    }

    @Test
    @DisplayName("showListOfAllFathers")
    public void shouldReturnListOfAllFathers() {
        List<String> parents = sqlService.getAllFathersNames();
        List<String> parentsFather = Arrays.asList("John", "Paul");

        Assertions.assertIterableEquals(parents, parentsFather);
    }

    @Test
    @DisplayName("showListOfAllFathersWithMoreThanOneChild")
    public void shouldReturnListOfAllFathersWithMoreThanOneChild() {
        List<String> parents = sqlService.getAllFathersNamesWithMoreThanOneChild();
        List<String> parentsFather = List.of("John");

        Assertions.assertIterableEquals(parents, parentsFather);
    }

    @Test
    @DisplayName("showListOfAllFathersAndMothers")
    public void shouldReturnListOfAllFathersAndMothers() {
        List<String> parents = sqlService.getAllFathersAndMothersNames();
        List<String> fathersAndMothers = Arrays.asList("John John Mary", "Paul John Mary",
                "Lucy Paul Lucy", "Claire John Lucy", "Simon Lucy");

        Assertions.assertIterableEquals(parents, fathersAndMothers);
    }

}
