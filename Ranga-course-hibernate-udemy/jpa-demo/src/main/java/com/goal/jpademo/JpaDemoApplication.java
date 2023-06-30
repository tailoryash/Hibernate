package com.goal.jpademo;

import com.goal.jpademo.entity.relation.Employee;
import com.goal.jpademo.liskov.Animal;
import com.goal.jpademo.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@Slf4j
@Transactional
public class JpaDemoApplication implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PassportRepository passportRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        byte[] bytes = {49, 94, 34, 39, 123, 34, 97, 98, 99, 100, 34, 58, 34, 85, 83, 34, 125, 39, 34, 10};
        String s = Base64.getEncoder().encodeToString(bytes);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));

        Employee arpit = new Employee(UUID.randomUUID().toString(), "a1000", "arpit");
        Employee parth = new Employee(UUID.randomUUID().toString(), "b2000", "parth");
        Employee yash = new Employee(UUID.randomUUID().toString(), "c3000", "yash");
        Employee kk = new Employee(UUID.randomUUID().toString(), "d4000", "kk");
        List<Employee> employees = List.of(arpit, parth, yash, kk);

        int average =
                employees.stream().map(Employee::getSalary).map(finalizedString -> Integer.parseInt((int)finalizedString.charAt(0) + finalizedString.substring(1))).reduce(0, Integer::sum)/employees.size();
        System.out.println(average);

        //log.info("{}",studentJpaRepository.findBydId(10));
        //log.info("{}",passportJpaRepository.findBydId(100));

        //bidirectional oneToOne save data
		/*studentJpaRepository.saveStudent();
		log.info("{}",studentJpaRepository.findBydId(1));
		log.info("{}",passportJpaRepository.findBydId(1));*/

        //OneToMany relation
/*
		courseRepository.saveCourseAndReviews();
		log.info("{}",courseRepository.findById(1).getReviews());
		log.info("{}",reviewRepository.findBydId(1).getCourse());
*/

        //ManyTOMany
/*		log.info("{}",studentJpaRepository.findBydId(10));
		log.info("{}",studentJpaRepository.findBydId(10).getCourses());
		studentJpaRepository.saveStudentAndCourse();
		log.info("{}",studentJpaRepository.findBydId(1).getCourses());
*/

        //SQL DELETE
/*		log.info("{} ", studentJpaRepository.findBydId(40));
		studentJpaRepository.deleteStudent(40);
		log.info("{} ", studentJpaRepository.findBydId(20));*/


/*
        //Inheritance Types
        Address add = new Address("line 1", "line 2", "City");
        Employee arpit = new FullTimeEmployee("john", add, new BigDecimal("2000"));
        employeeRepository.saveEmployee(arpit);
        arpit = new PartTimeEmployee("Jill", add, new BigDecimal("200"));
        employeeRepository.saveEmployee(arpit);

        log.info("{}",employeeRepository.findAll());*/


    }

    static String putAnimal(Animal animal) {
        System.out.println(animal.getName());
        return animal.getName();
    }

}
