package com.token.assessment.sqlassessment.controller;

import com.token.assessment.sqlassessment.service.SqlService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sqls")
public class SqlController {

    private final SqlService sqlService;

    public SqlController(SqlService sqlService) {
        this.sqlService = sqlService;
    }

    @Operation(summary = "return List of Fathers names")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "fathers name returned",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class))})})
    @GetMapping(value = "/sql1")
    public ResponseEntity<List<String>> sql1() {
        List<String> parents = sqlService.getAllFathersNames();
        return new ResponseEntity<>(parents, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "return List of Fathers names with more than one child")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "fathers name returned",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class))})})
    @GetMapping(value = "/sql2")
    public ResponseEntity<List<String>> sql2() {
        List<String> parents = sqlService.getAllFathersNamesWithMoreThanOneChild();
        return new ResponseEntity<>(parents, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "return List of Parents of each children")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "parents name returned",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class))})})
    @GetMapping(value = "/sql3")
    public ResponseEntity<List<String>> sql3() {
        List<String> parents = sqlService.getAllFathersAndMothersNames();
        return new ResponseEntity<>(parents, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "return number of john's children")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "John childrens count",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = int.class))})})
    @GetMapping(value = "/sql4")
    public ResponseEntity<Integer> sql4() {
        int childrenCount = sqlService.getChildrensFromId(1, "father");
        return new ResponseEntity<>(childrenCount, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "return number of Mary's children")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Mary childrens count",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = int.class))})})
    @GetMapping(value = "/sql5")
    public ResponseEntity<Integer> sql5() {
        int childrenCount = sqlService.getChildrensFromId(3, "mother");
        return new ResponseEntity<>(childrenCount, HttpStatus.ACCEPTED);
    }
}
