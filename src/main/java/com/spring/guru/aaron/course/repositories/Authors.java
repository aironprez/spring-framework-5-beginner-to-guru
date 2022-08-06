package com.spring.guru.aaron.course.repositories;

import com.spring.guru.aaron.course.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface Authors extends CrudRepository<Author, Long> {
}
