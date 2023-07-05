package com.yashtailor.entitymanager.service;

import com.yashtailor.entitymanager.entity.*;
import com.yashtailor.entitymanager.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
//    public List<Author> getAuthorDetails() {
//        List<Author> authorList = authorRepository.findAll();
//        return authorList;
//    }
//
//    public void addMultipleBooksFromAuthor(Author author) {
//        authorRepository.save(author);
//    }
}
