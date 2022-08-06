package com.spring.guru.aaron.course.repositories;

import com.spring.guru.aaron.course.entities.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface Publishers extends CrudRepository<Publisher, Long> {
}
