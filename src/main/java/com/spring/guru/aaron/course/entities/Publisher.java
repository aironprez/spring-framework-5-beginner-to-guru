package com.spring.guru.aaron.course.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@ToString
@Entity
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @EqualsAndHashCode.Include
  private Long id;

  @NonNull
  private String name;

  @ManyToOne
  @JoinColumn(name = "address_id")
  @NonNull
  private Address address;

  @OneToMany(cascade = CascadeType.ALL)
  private Set<Book> books = new HashSet<>();

  public boolean addBook(Book book) {
    return books.add(book);
  }

  public boolean removeBook(Book book) {
    return books.remove(book);
  }

}
