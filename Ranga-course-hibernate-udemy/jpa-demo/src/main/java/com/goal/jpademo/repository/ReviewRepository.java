package com.goal.jpademo.repository;

import com.goal.jpademo.entity.relation.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReviewRepository {

    //EM is the interface of PC
    @PersistenceContext
    EntityManager entityManager;

    public Review findBydId(int id){
        return entityManager.find(Review.class,id);
    }

}
