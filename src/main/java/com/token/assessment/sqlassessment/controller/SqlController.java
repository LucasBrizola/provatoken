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
}
