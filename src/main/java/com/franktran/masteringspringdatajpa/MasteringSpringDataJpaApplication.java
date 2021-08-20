package com.franktran.masteringspringdatajpa;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class MasteringSpringDataJpaApplication {

  public static void main(String[] args) {
    SpringApplication.run(MasteringSpringDataJpaApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
    return args -> {
      generateRandomStudents(studentRepository);
      Sort sort = Sort.by("firstName").descending()
          .and(Sort.by("age").ascending());
      studentRepository
          .findAll(sort)
          .forEach(student -> System.out.println(String.format("%s %s", student.getFirstName(), student.getAge())));
    };
  }

  private void generateRandomStudents(StudentRepository studentRepository) {
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
  }

}
