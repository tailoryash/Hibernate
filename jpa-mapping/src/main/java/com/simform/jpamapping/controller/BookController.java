package com.simform.jpamapping.controller;

import com.simform.jpamapping.entity.*;
import com.simform.jpamapping.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBookAndAuthor(@RequestBody Book book) {
        Book book1 = bookService.addBookDetails(book);
        return new ResponseEntity<>(book1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>("Deleted book", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateById(@RequestBody Book book, @PathVariable("id") Long id){
        Book updatedBook = bookService.updateBook(book, id);
        return ResponseEntity.ok(updatedBook);
    }
}
