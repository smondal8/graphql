package com.example.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity(name = "Book")
public class Book {
    @Id
    private int id;
    private String name;
    private int pages;
}
