package com.example.onetomany.service;

import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Book;
import com.example.onetomany.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public void create(Book book) {
        Author author = book.getAuthor();
        book.setAuthor(author);
        bookRepository.save(book);
    }

    /**
     * ek book exist ->> author exist to change author name
     *               ->> author exist to change author
     *                      ---> create new author
     *                      ---> change author which exits already
     */

}
