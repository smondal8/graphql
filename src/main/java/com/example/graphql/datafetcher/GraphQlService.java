package com.example.graphql.datafetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class GraphQlService {
    @Value("classpath:schema.graphql")
    Resource resource;
    private GraphQL graphQL;
    @Autowired
    private CustomizedDataFetcher dataFetcher;

    @PostConstruct
    private void loadSchema() throws IOException {
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser()
                .parse(resource.getInputStream());
        RuntimeWiring runtimeWiring = buildRuntieWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry,runtimeWiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntieWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query",typeWiring->typeWiring.dataFetcher("getBook",dataFetcher.getBook()))
                .type("Query",typeWiring->typeWiring.dataFetcher("getBooks",dataFetcher.getBooks()))
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}
