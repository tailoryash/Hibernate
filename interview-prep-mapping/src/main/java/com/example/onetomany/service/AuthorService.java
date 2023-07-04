package com.example.onetomany.service;

import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Book;
import com.example.onetomany.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public void create(Author author) {
        author.getBooks().forEach(book -> book.setAuthor(author));
        authorRepository.save(author);
    }

    public void addBookInAuthor(int id, Book book) {
        Optional<Author> byId = authorRepository.findById(id);
        if (byId.isPresent()) {
            Author author = byId.get();
            author.addBook(book);
            authorRepository.save(author);
        } else {
            throw new RuntimeException("Author Not Found");
        }
    }
}
