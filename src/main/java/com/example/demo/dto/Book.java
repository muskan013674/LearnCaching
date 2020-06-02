package com.example.demo.dto;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Book {
    @Id
    private int id;
    private String name;
    private String category;
    private String author;
    private String publisher;
    private String edition;

    public Book() {
    }

}
