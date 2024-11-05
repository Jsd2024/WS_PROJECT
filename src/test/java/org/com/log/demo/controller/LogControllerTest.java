package org.com.log.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.com.log.demo.model.Book;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.mockito.MockedStatic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LogControllerTest {

  private static final Logger logger = LoggerFactory.getLogger(LogControllerTest.class);

  @Autowired
  MockMvc mockMvc;


  @Test
  public void testMockPrivateStaticMethod() throws Exception {
//    try (MockedStatic<LogController> mockedStatic = mockStatic(LogController.class)) {
      // Mock the private static method to return a custom value
//      mockedStatic.when(LogController::getBookData).thenReturn("Mocked Value");
//
//      // Create an instance of MyClass and invoke the public method
//      MyClass myClass = new MyClass();
//      String result = myClass.publicMethod();

      // Assert that the mocked static method value is returned
      Method privateMethod =LogController.class.getDeclaredMethod("getBookData", null);
      privateMethod.setAccessible(true);
      List<Book> books = new ArrayList<>();
//      doReturn(books).when(, "method2"); // if private method2 is returning string data
      // invoke the private method for test
      privateMethod.invoke(LogController.class , null);

    mockMvc.perform(get("/api/junit")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$[0].title", is("The Lord of the Rings")))
            .andExpect(jsonPath("$[0].author", is("J.R.R. Tolkien")))
            .andExpect(jsonPath("$[0].publicationYear", is(1954)))
            .andExpect(jsonPath("$[1].title", is("Harry Potter and the Sorcerer's Stone")))
            .andExpect(jsonPath("$[1].author", is("J.K. Rowling")))
            .andExpect(jsonPath("$[1].publicationYear", is(1997)));
  }

}
