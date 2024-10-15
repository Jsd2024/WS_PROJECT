package org.com.crnk.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    logger.info("Handling /example request usin logger");

    log.info("Handling /example request slf4j log");

    return "This is a response with a correlation ID.";
  }
}
