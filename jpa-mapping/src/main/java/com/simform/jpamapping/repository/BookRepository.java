package com.simform.jpamapping.repository;

import com.simform.jpamapping.entity.*;
import org.springframework.data.jpa.repository.*;

public interface BookRepository extends JpaRepository<Book, Long> {
}
