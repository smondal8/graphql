package com.example.graphql.datafetcher;

import com.example.graphql.model.Book;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CustomizedDataFetcher {
    public DataFetcher<Book> getBook(){
        return environment -> {
            int id = environment.getArgument("id");
            log.info("The Book is being fetched for the id : {}",id);
            return new Book(100,"Sumya's book",1000);
        };
    }
    public DataFetcher<List<Book>> getBooks(){
        return environment -> {
            ArrayList<Book> list = new ArrayList<>();
            log.info("All the books are being fetched");
            list.add(new Book(100,"Soumya's book",1000));
            list.add(new Book(101,"Soumya's second book",1001));
            return list;
        };
    }
}
