package com.example.onetomany.controlller;

import com.example.onetomany.entity.Book;
import com.example.onetomany.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    public void create(@RequestBody Book book) {
        bookService.create(book);
    }

}
