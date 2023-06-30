package com.goal.jpademo.repository;

import com.goal.jpademo.entity.relation.Course;
import com.goal.jpademo.entity.relation.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Slf4j
@Transactional
public class CourseRepository {

    //EM is the interface of PC
    @PersistenceContext
    EntityManager entityManager;

    public List<Course> findAll(){
        return entityManager.createQuery("Select c from Course c",Course.class).getResultList();
    }

    public Course namedQueryFindById(int id){
        TypedQuery<Course> namedQuery = entityManager.createNamedQuery("Course.findById", Course.class);
        namedQuery.setParameter("id",id);
        return namedQuery.getSingleResult();
    }

    public Course findById(int id){
        return entityManager.find(Course.class,id);
    }

    public void deleteById(int id) {
        Course course = findById(id);
        course.getStudents().forEach(
                student -> student.removeCourse(course)
        );
        //course.setStudents(null);
        entityManager.remove(course);
    }

    public Course updateCourse(Course course) {

        List<Review> reviews = course.getReviews();
        if (course.getId() == 0) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }
        if(!reviews.isEmpty()){
            reviews.forEach(review -> {
                review.setCourse(course);
                if(review.getId() == 0)
                    entityManager.persist(review);
                else
                    entityManager.merge(review);
            });
        }

        return course;
    }

    public void saveCourseAndReviews(){
        Course course = new Course();
        course.setName("JPA");
        entityManager.persist(course);

        Review review = new Review();
        review.setRating(5);
        review.setDescription("Good Review");

        Review review1 = new Review();
        review1.setRating(4);
        review1.setDescription("Best Review");

        course.addReview(review);
        course.addReview(review1);
        entityManager.persist(review);
        entityManager.persist(review1);
    }

    public Course cacheDemo(){
        return findById(10001);
    }

    public void detachClear(){
        Course course = new Course();
        course.setName("Course");

        Course course1 = new Course();
        course1.setName("Course 1");

        entityManager.persist(course);
        entityManager.persist(course1);

        course.setName("Course Updated");
        entityManager.flush();

        entityManager.detach(course1);
        course1.setName("Course 1 Updated");
        entityManager.clear();
        course.setName("Course Updated Twice");

    }

    public void refresh(){
        Course course = new Course();
        course.setName("Course");

        entityManager.persist(course);
        course.setName("HELLO WORLD");
        entityManager.refresh(course);
        log.info("Refreshed Course Name {}",course.getName() );

    }
}
