package com.goal.jpademo.repository;

import com.goal.jpademo.entity.relation.Course;
import com.goal.jpademo.entity.relation.Passport;
import com.goal.jpademo.entity.relation.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Repository
@Transactional
public class StudentRepository {

    //EM is the interface of PC
    @PersistenceContext
    EntityManager entityManager;


    public Student findBydId(int id) {
        return entityManager.find(Student.class, id);
    }
    // if id is present insert object else update object
    public Student insertUpdate(Student student) {
        return entityManager.merge(student);
    }

    public void deleteById(int id) {
        Student student = findBydId(id);
        List<Course> courses = student.getCourses();
        courses.forEach(course -> course.removeStudent(student));
        student.setCourses(null);
        entityManager.remove(student);
    }

    public List<Student> findAll() {
        return entityManager.createNamedQuery("Student.findAll", Student.class).getResultList();
    }

    public Student saveStudent(Student student) {
        Passport passport = new Passport();
        passport.setNumber(String.valueOf(new Random().nextInt(100000)));

        entityManager.persist(student);
        passport.setStudent(student);
        entityManager.persist(passport);
        entityManager.refresh(student);
        return student;
    }

    public Student updateStudent(Student student) {
        Student existingStudent = findBydId(student.getId());
        if (existingStudent == null)
            return null;
        existingStudent.setName(student.getName());
        existingStudent.setLocation(student.getLocation());
        existingStudent.setBirthDate(student.getBirthDate());
        entityManager.merge(existingStudent);
        return existingStudent;
    }

    public void saveStudentAndCourse(Student student, Course course) {

        student.addCourse(course);
        course.addStudent(student);
        entityManager.refresh(student);
        entityManager.persist(student);
        entityManager.persist(course);
    }


    public List<Student> studentsWithStartingLetterA() {

        // 1. Use Criteria Builder to create a Criteria Query returning the
        // expected result object
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);

        // 2. Define roots for tables which are involved in the query
        Root<Student> stundentRoot = cq.from(Student.class);

        // 3. Define Predicates etc using Criteria Builder
        Predicate studentsIsEmpty = cb.like(cb.lower(stundentRoot.get("name")),"%a%");

        // 4. Add Predicates etc to the Criteria Query
        cq.where(studentsIsEmpty);

        // 5. Build the TypedQuery using the entity manager and criteria query
        TypedQuery<Student> query = entityManager.createQuery(cq.select(stundentRoot));

        return query.getResultList();

        // [Course[Spring in 50 Steps]]
    }
}
