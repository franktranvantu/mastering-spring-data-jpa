package com.franktran.masteringspringdatajpa;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MasteringSpringDataJpaApplication {

  public static void main(String[] args) {
    SpringApplication.run(MasteringSpringDataJpaApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
    return args -> {
      Faker faker = new Faker();
      for (int i = 0; i < 20; i++) {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        Student student = new Student(
            firstName,
            lastName,
            String.format("%s@gmail.com", firstName.toLowerCase()),
            faker.number().numberBetween(18, 40));

        studentRepository.save(student);
      }
    };
  }

}
