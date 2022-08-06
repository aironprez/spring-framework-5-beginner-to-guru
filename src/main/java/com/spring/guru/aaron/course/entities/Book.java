package com.spring.guru.aaron.course.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NonNull
  private String title;

  @NonNull
  private String isbn;

  @ManyToMany(mappedBy = "author_book")
  private Set<Author> authors = new HashSet<>();
}
