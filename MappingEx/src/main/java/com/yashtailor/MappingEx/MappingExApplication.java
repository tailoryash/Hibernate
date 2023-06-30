package com.yashtailor.MappingEx;

import com.yashtailor.MappingEx.entity.*;
import com.yashtailor.MappingEx.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class MappingExApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(MappingExApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		studentRepository.saveStudentWithPassport();
//		courseRepository.addReviewForCourse();
		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("5", "Great hand-ons stuff - Great teacher"));
		reviews.add(new Review("4", "Best Java Teacher"));
		courseRepository.addReviewForCourse(10003L, reviews);
	}
}
