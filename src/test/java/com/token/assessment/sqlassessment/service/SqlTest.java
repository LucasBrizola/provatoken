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
    public static void setup(){

    }
    @Test
    @DisplayName("showListOfAllFathers")
    public void shouldReturnListOfAllFathers(){
        List<String> parents = sqlService.getAllFathersNames();
        List<String> parentsFather = Arrays.asList("John","Paul");

        Assertions.assertIterableEquals(parents,parentsFather);
    }

}
