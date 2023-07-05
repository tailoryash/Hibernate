package com.yashtailor.entitymanager.repository;

import com.yashtailor.entitymanager.entity.*;
import jakarta.persistence.*;
import jakarta.transaction.*;
import org.springframework.stereotype.*;

import java.util.*;
@Repository
public class BookRepository {
    @PersistenceContext
    private EntityManager entityManager;


    public List<Book> findAll(){
//        String query = "SELECT b FROM Book b ";
        Query nativeQuery = entityManager.createNativeQuery("select books.id, books.title, authors.id, authors.name from books , authors where books.author_id=authors.id");
        List<Book> resultList = nativeQuery.getResultList();
        return resultList;
    }
    @Transactional
    public void save(Book book){
        entityManager.persist(book);
    }

}
