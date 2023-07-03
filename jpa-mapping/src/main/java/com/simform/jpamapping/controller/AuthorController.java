package com.simform.jpamapping.controller;

import com.simform.jpamapping.entity.*;
import com.simform.jpamapping.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @GetMapping
    public ResponseEntity<List<Author>> getAuthor(){
        List<Author> authorDetails = authorService.getAuthorDetails();
        return new ResponseEntity<>(authorDetails, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        authorService.addMultipleBooksFromAuthor(author);
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }
}
