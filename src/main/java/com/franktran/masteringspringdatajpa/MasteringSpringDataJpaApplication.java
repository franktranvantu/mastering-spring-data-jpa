package com.franktran.masteringspringdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class MasteringSpringDataJpaApplication {

  public static void main(String[] args) {
    SpringApplication.run(MasteringSpringDataJpaApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
    return args -> {
      Student frank = new Student("Frank", "Tran", "frank@gmail.com", 21);
      Student henry = new Student("Henry", "Tran", "henry@gmail.com", 34);

      studentRepository.saveAll(Arrays.asList(frank, henry));

      studentRepository
          .findStudentByEmail(frank.getEmail())
          .ifPresent(System.out::println);
    };
  }

}
