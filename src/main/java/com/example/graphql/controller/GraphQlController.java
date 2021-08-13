package com.example.graphql.controller;

import com.example.graphql.datafetcher.GraphQlService;
import com.example.graphql.model.GraphQlRequestBody;
import graphql.ExecutionInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GraphQlController {
    @Autowired
    GraphQlService graphQlService;
    @PostMapping("/graphql")
    public ResponseEntity<Map<String, Object>> execute(@RequestBody GraphQlRequestBody body){
        return new ResponseEntity<> (graphQlService.getGraphQL().execute(ExecutionInput.newExecutionInput()
                .query(body.getQuery())
                .operationName(body.getOperationName())
                .variables(body.getVariables()).build()).toSpecification(), HttpStatus.OK);

    }
    @GetMapping("/test")
    public String test(){
        return "Testing correct";
    }
}
