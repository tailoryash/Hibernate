package com.yashtailor.MappingEx.repository;

import com.yashtailor.MappingEx.*;
import com.yashtailor.MappingEx.entity.*;
import jakarta.persistence.*;
import lombok.extern.slf4j.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.transaction.annotation.*;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest(classes = MappingExApplication.class)
public class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void getStudentAndPassportDetails(){
        Student student = em.find(Student.class, 20001L);
        log.info("student -> {}", student);
        log.info("passport -> {}", student.getPassport());
    }

    @Test
    public void someTest(){
        studentRepository.someDummyOperationWithPersistenceContext();
    }
}