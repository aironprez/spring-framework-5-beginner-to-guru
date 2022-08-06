package com.spring.guru.aaron.course.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;

  @NonNull
  private String firstName;

  @NonNull
  private String lastName;

  @ManyToMany(mappedBy = "author_book")
  private Set<Book> books = new HashSet<>();
}
