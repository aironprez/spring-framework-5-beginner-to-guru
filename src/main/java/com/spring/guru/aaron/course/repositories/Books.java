package com.spring.guru.aaron.course.repositories;

import com.spring.guru.aaron.course.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface Books extends CrudRepository<Book, Long> {
}
