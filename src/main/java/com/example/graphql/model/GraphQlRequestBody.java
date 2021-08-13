package com.example.graphql.model;

import lombok.Data;

import java.util.Map;

@Data
public class GraphQlRequestBody {
    private String query;
    private String operationName;
    private Map<String, Object> variables;
}
