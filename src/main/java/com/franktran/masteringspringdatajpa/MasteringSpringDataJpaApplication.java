package com.franktran.masteringspringdatajpa;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;

@SpringBootApplication
public class MasteringSpringDataJpaApplication {

  public static void main(String[] args) {
    SpringApplication.run(MasteringSpringDataJpaApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(
      StudentRepository studentRepository,
      StudentIdCardRepository studentIdCardRepository
  ) {
    return args -> {
      Faker faker = new Faker();
      String firstName = faker.name().firstName();
      String lastName = faker.name().lastName();
      Student student = new Student(
          firstName,
          lastName,
          String.format("%s@gmail.com", firstName.toLowerCase()),
          faker.number().numberBetween(18, 40));
      StudentIdCard studentIdCard = new StudentIdCard("1234567890", student);

      student.addBook(new Book(faker.book().title(), LocalDateTime.now().minusYears(5)));
      student.addBook(new Book(faker.book().title(), LocalDateTime.now().minusYears(4)));
      student.addBook(new Book(faker.book().title(), LocalDateTime.now().minusYears(3)));
      student.setStudentIdCard(studentIdCard);

      student.addEnrolment(
          new Enrolment(
              new EnrolmentId(student.getId(), 1L),
              new Course("Mastering Spring Data JPA", "IT"),
              student
          )
      );
      student.addEnrolment(
          new Enrolment(
              new EnrolmentId(student.getId(), 2L),
              new Course("Mastering Spring Boot", "IT"),
              student
          )
      );

      studentRepository.save(student);

      studentRepository
          .findById(1L)
          .ifPresent(s -> {
            student.getBooks().forEach(
                b -> System.out.println(
                    String.format("%s borrowed %s", s.getFirstName(), b.getBookName())
                )
            );
          });
    };
  }

  private void sorting(StudentRepository studentRepository) {
    Sort sort = Sort.by("firstName").descending()
        .and(Sort.by("age").ascending());
    studentRepository
        .findAll(sort)
        .forEach(student -> System.out.println(String.format("%s %s", student.getFirstName(), student.getAge())));
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
