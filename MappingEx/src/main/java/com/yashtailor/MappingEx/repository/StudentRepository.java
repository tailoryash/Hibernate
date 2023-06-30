package com.yashtailor.MappingEx.repository;

import com.yashtailor.MappingEx.entity.*;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Repository
@Slf4j
@Transactional
public class StudentRepository {
    @Autowired
    EntityManager em;

    public void saveStudentWithPassport(){
        Passport passport = new Passport("Z2344G");
        em.persist(passport);
        Student student = new Student("Aprpit");
        student.setPassport(passport);
        em.persist(student);
    }

    public void someDummyOperationWithPersistenceContext(){
        Student student  = em.find(Student.class, 20001L);
        Passport passport = student.getPassport();
        passport.setNumber("E2454v");
        em.persist(passport);
        student.setName("Ranga- updated");
        em.persist(student);
    }
}
