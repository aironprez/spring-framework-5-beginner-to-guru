package com.spring.guru.aaron.course.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @EqualsAndHashCode.Include
  private Long id;

  @NonNull
  private String title;

  @NonNull
  private String isbn;

  @ManyToMany
  @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "author_id"))
  private Set<Author> authors = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "publisher_id")
  private Publisher publisher;

  public boolean addAuthor(Author author) {
    return authors.add(author);
  }

  public boolean removeAuthor(Author author) {
    return authors.remove(author);
  }

  @Override
  public String toString() {
    String authorsNames = getListOfAuthorsNames();
    String simplePublisherString = getSimplePublisherString();
    return "Book{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", isbn='" + isbn + '\'' +
        ", authors='" + authorsNames + '\'' +
        ", publisher='" + simplePublisherString + '\'' +
        '}';
  }

  private String getListOfAuthorsNames() {
    return authors.stream().map(author -> author.getLastName() + ", " + author.getFirstName())
        .collect(Collectors.toSet()).toString();
  }

  private String getSimplePublisherString() {
    return "Publisher{" +
        "id=" + publisher.getId() +
        ", name='" + publisher.getName() + '\'' +
        ", address=" + publisher.getAddress() +
        '}';
  }
}
