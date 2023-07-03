package com.simform.jpamapping.service;

import com.simform.jpamapping.entity.*;
import com.simform.jpamapping.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository  authorRepository;
    public List<Author> getAuthorDetails() {
        List<Author> authorList = authorRepository.findAll();
        return authorList;
    }

    public void addMultipleBooksFromAuthor(Author author) {
        authorRepository.save(author);
    }
}
