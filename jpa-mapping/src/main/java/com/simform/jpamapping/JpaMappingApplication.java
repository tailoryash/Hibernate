package com.simform.jpamapping;

import com.simform.jpamapping.entity.*;
import com.simform.jpamapping.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaMappingApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(JpaMappingApplication.class, args);
	}
	@Autowired
	private TagRepository tagRepository;
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		postRepository.deleteAllInBatch();
		tagRepository.deleteAllInBatch();

		Post post = new Post("Hibernate many to many ex", "Hibernate is very easy course", "Hibernate content");
		Tag tag1 = new Tag("Springboot");
		Tag tag2 = new Tag("Hibernate");
		post.getTags().add(tag1);
		post.getTags().add(tag2);
		postRepository.save(post);
	}
}
