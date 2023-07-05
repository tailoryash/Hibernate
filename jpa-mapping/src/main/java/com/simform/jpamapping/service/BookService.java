package com.simform.jpamapping.service;

import com.simform.jpamapping.entity.*;
import com.simform.jpamapping.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book addBookDetails(Book book) {
        Author author = book.getAuthor();
        author.addBook(book);
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).stream().findFirst().get();
        Author author = book.getAuthor();
        author.removeBook(book);
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book book, Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent() ){
            Book existingBook = optionalBook.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            bookRepository.save(existingBook);
        }
        book.setId(id);
        return book;
    }

    public Book findBookById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if(book == null){
            throw new RuntimeException("Not Found ");
        }else{
                return book;
        }
    }
}
