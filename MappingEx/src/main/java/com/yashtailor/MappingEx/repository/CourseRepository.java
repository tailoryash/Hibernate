package com.yashtailor.MappingEx.repository;

import com.yashtailor.MappingEx.entity.*;
import jakarta.persistence.*;
import jakarta.transaction.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
@Slf4j
@Transactional
public class CourseRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Course findById(Long id){
        return entityManager.find(Course.class, id);
    }
 /*   public void addReviewForCourse(){
        Course course = findById(10003L);
        log.info("Course.getReview() -> {}", course.getReviews());

        Review review1 = new Review("5", "Great hands on stuff. ");
        Review review2 = new Review("5", "Hatoffs");
        course.addReview(review1);
        review1.setCourse(course);
        course.addReview(review2);
        review2.setCourse(course);

        entityManager.persist(review1);
        entityManager.persist(review2);
    }*/

       public void addReviewForCourse(Long courseId, List<Review> reviews){
        Course course = findById(courseId);
        log.info("Course.getReview() -> {}", course.getReviews());
        for(Review review : reviews){
            course.addReview(review);
            review.setCourse(course);
            entityManager.persist(review);
        }
    }
}
