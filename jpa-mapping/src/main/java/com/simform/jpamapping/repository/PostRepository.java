package com.simform.jpamapping.repository;

import com.simform.jpamapping.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
