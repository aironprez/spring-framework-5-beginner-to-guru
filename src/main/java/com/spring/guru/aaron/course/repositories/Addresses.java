package com.spring.guru.aaron.course.repositories;

import com.spring.guru.aaron.course.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface Addresses extends CrudRepository<Address, Long> {
}
