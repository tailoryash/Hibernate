package com.yashtailor.entitymanager.service;


import com.yashtailor.entitymanager.entity.*;
import com.yashtailor.entitymanager.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public void addBookDetails(Book book) {
        Author author = book.getAuthor();
        author.addBook(book);
        bookRepository.save(book);
    }
//
//    public void deleteBook(Long id) {
//        Book book = bookRepository.findById(id).stream().findFirst().get();
//        Author author = book.getAuthor();
//        author.removeBook(book);
//        bookRepository.deleteById(id);
//    }
//
//    public Book updateBook(Book book, Long id) {
//        Optional<Book> optionalBook = bookRepository.findById(id);
//        if(optionalBook.isPresent() ){
//            Book existingBook = optionalBook.get();
//            existingBook.setTitle(book.getTitle());
//            existingBook.setAuthor(book.getAuthor());
//            bookRepository.save(existingBook);
//        }
//        book.setId(id);
//        return book;
//    }

    public List<Book> findAll() {
        List<Book> books = bookRepository.findAll();
        return books;
    }
}
