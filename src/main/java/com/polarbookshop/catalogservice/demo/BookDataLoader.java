package com.polarbookshop.catalogservice.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookRepository;

@Component
// @Profile("testdata")
@ConditionalOnProperty(name = "polar.testdata.enabled", havingValue = "true")
public class BookDataLoader {

  private final BookRepository bookRepository;

  public BookDataLoader(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void loadBookTestData() {
    var book1 = new Book("1234567891", "Northern lights", "Susan S", 7.8);
    var book2 = new Book("1234567892", "Aurora Borealis", "Xavier X", 5.5);
    bookRepository.save(book1);
    bookRepository.save(book2);
  }
  
  
}
