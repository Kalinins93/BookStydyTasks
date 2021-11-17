package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan("org.example")
public class ServingWebContentApplication   {

        public static void main(String[] args) {
                SpringApplication.run(ServingWebContentApplication.class, args);
        }
}