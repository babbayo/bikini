package com.ittaga.bikini;

import com.ittaga.bikini.domain.Project;
import com.ittaga.bikini.domain.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class BikiniApplication {

    public static void main(String[] args) {
        SpringApplication.run(BikiniApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProjectRepository repository) {
        return (args) -> {
            // save a couple of customersentityManagerFactory
            repository.save(new Project(1L, "Jack"));
            repository.save(new Project(2L, "Chloe"));
            repository.save(new Project(3L, "Kim"));
            repository.save(new Project(4L, "David"));
            repository.save(new Project(5L, "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Project customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            repository.findById(1L)
                    .ifPresent(customer -> {
                        log.info("Customer found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    });

            // fetch customers by last name
            log.info("Customer found with findByName('Dessler'):");
            log.info("--------------------------------------------");
            repository.findByName("Dessler").forEach(bauer -> log.info(bauer.toString()));
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}

