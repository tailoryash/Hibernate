package com.yashtailor.entitymanager.controller;


import com.yashtailor.entitymanager.entity.*;
import com.yashtailor.entitymanager.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBookAndAuthor(@RequestBody Book book) {
        bookService.addBookDetails(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteBookById(@PathVariable("id") Long id){
//        bookService.deleteBook(id);
//        return new ResponseEntity<>("Deleted book", HttpStatus.OK);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Book> updateById(@RequestBody Book book, @PathVariable("id") Long id){
//        Book updatedBook = bookService.updateBook(book, id);
//        return ResponseEntity.ok(updatedBook);
//    }

    @GetMapping
    public ResponseEntity<List<Book>> findAllBooks(){
        List<Book> bookList = bookService.findAll();
        return ResponseEntity.ok(bookList);
    }
}
