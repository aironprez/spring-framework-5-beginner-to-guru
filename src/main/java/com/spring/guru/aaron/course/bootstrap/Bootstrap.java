package com.spring.guru.aaron.course.bootstrap;

import com.spring.guru.aaron.course.entities.Address;
import com.spring.guru.aaron.course.entities.Author;
import com.spring.guru.aaron.course.entities.Book;
import com.spring.guru.aaron.course.entities.Publisher;
import com.spring.guru.aaron.course.repositories.Addresses;
import com.spring.guru.aaron.course.repositories.Authors;
import com.spring.guru.aaron.course.repositories.Books;
import com.spring.guru.aaron.course.repositories.Publishers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

  Logger logger = LoggerFactory.getLogger(Bootstrap.class);

  private final Authors authorsRepo;
  private final Books booksRepo;
  private final Publishers publishersRepo;
  private final Addresses addressesRepo;

  public Bootstrap(Authors authorsRepo, Books booksRepo, Publishers publishersRepo, Addresses addressesRepo) {
    this.authorsRepo = authorsRepo;
    this.booksRepo = booksRepo;
    this.publishersRepo = publishersRepo;
    this.addressesRepo = addressesRepo;
  }

  @Override
  public void run(String... args) throws Exception {
    createAuthorAndBook();
    createPublisher();
  }

  private void createAuthorAndBook() {
    Author hemingway = new Author("Ernest", "Hemingway");
    Book theSunAlsoRises = new Book("The Sun Also Rises", "9780020518709");

    hemingway.addBook(theSunAlsoRises);
    theSunAlsoRises.addAuthor(hemingway);

    logger.debug(hemingway.toString());
    logger.debug("number of authors: {}", authorsRepo.count());
    logger.debug("number of books: {}", booksRepo.count());

    authorsRepo.save(hemingway);
    booksRepo.save(theSunAlsoRises);

    logger.debug(hemingway.toString());
    logger.debug("number of authors: {}", authorsRepo.count());
    logger.debug("number of books: {}", booksRepo.count());
  }

  private void createPublisher() {
    Address address = new Address("123 Asdf St", "Houston", "TX", "77009");
    Publisher publisher = new Publisher("BadAss Publisher", address);

    logger.debug(publisher.toString());
    logger.debug("number of publishers: {}", publishersRepo.count());
    logger.debug("number of addresses: {}", addressesRepo.count());

    addressesRepo.save(address);
    publishersRepo.save(publisher);
    logger.debug(publisher.toString());
    logger.debug("number of publishers: {}", publishersRepo.count());
    logger.debug("number of addresses: {}", addressesRepo.count());
  }
}
