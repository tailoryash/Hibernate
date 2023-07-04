package com.example.onetomany.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        book.setAuthor(this);
        this.books.add(book);
    }
}
