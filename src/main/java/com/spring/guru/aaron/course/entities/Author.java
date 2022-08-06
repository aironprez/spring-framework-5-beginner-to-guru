package com.spring.guru.aaron.course.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @EqualsAndHashCode.Include
  Long id;

  @NonNull
  private String firstName;

  @NonNull
  private String lastName;

  @ManyToMany(mappedBy = "authors")
  private Set<Book> books = new HashSet<>();

  public boolean addBook(Book book) {
    return books.add(book);
  }

  public boolean removeBook(Book book) {
    return books.remove(book);
  }
}
