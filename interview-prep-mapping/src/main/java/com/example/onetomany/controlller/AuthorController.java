package com.example.onetomany.controlller;

import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Book;
import com.example.onetomany.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping
    public void create(@RequestBody Author author) {
        authorService.create(author);
    }

    @PostMapping("/book/{id}")
    public void create(@PathVariable int id, @RequestBody Book book) {
        authorService.addBookInAuthor(id,book);
    }
}
