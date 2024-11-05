package org.com.log.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.com.log.demo.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
@Slf4j
@RestController
@RequestMapping("/api")
public class LogController {

  private static final Logger logger = LoggerFactory.getLogger(LogController.class);

  @GetMapping("/example")
  public String example() {
    // Log with correlation ID from MDC
    String correlationId= UUID.randomUUID().toString();
    MDC.put("ggid", correlationId);

    logger.info("Handling /example request using org slf4j logger");

    log.info("Handling /example request lombok slf4j log");

    return "This is a response with a correlation ID.";
  }



  @GetMapping("/books")
  public ResponseEntity<List<Book>> getBooks() {
    // Log with correlation ID from MDC
    String correlationId= UUID.randomUUID().toString();
    MDC.put("ggid", correlationId);
    Book book1 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
    Book book2 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997);

    System.out.println(book1);
    System.out.println(book2);
    logger.info("Handling /example request using org slf4j logger"+book1);


    List<Book> bookList= Arrays.asList(book1,book2);

    log.info("Handling /example request lombok slf4j log"+book2);

    return new ResponseEntity<>(bookList, HttpStatus.OK);
  }

  @GetMapping("/junit")
  public ResponseEntity<?> getJunits() {
    // Log with correlation ID from MDC
    String correlationId= UUID.randomUUID().toString();
    MDC.put("ggid", correlationId);
    List<Book> bookList= getBookData();
    return new ResponseEntity<>(bookList, HttpStatus.OK);
  }

  private static List<Book> getBookData() {
    try {
      Book book1 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
      Book book2 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997);

      System.out.println(book1);
      System.out.println(book2);
      logger.info("Handling /example request using org slf4j logger" + book1);
      log.info("Handling /example request lombok slf4j log" + book2);
      List<Book> books = Arrays.asList(book1, book2);
      return books;
    } catch (Exception e) {
      log.info("Handling Exception printed using lombok slf4j log" + e);
      return java.util.Collections.emptyList();
       // throw new RuntimeException(e);
    }


  }

//  public static void getBookData() {
//  }
}
