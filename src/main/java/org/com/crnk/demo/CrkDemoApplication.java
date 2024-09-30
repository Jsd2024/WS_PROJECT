package org.com.crnk.demo;

import io.crnk.spring.boot.v3.CrnkConfigV3;
import org.com.crnk.demo.model.Task;
import org.com.crnk.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EntityScan(basePackages = "org.com.crnk.demo.model")
// Ensure this matches your entity package@EnableJpaRepositories(basePackages = "org.com.crnk.demo.repository")
@EnableJpaRepositories(basePackages = "org.com.crnk.demo.repository")// Ensure this matches your repository package
@ComponentScan(basePackages = "org.com.crnk.demo")  // Ensure the base package is correct
//@Import({CrnkConfigV3.class})
public class CrkDemoApplication {
    public static void main(String[] args) {
        // The SpringApplication.run method starts the Spring Boot application
        SpringApplication.run(CrkDemoApplication.class, args);
    }



}
