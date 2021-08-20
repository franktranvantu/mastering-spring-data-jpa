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

      System.out.println("Adding frank and henry");
      studentRepository.saveAll(Arrays.asList(frank, henry));

      System.out.print("Number of students: ");
      studentRepository.count();

      studentRepository.findById(1L).ifPresent(System.out::println);

      System.out.println("Select all students");
      studentRepository
          .findAll()
          .forEach(System.out::println);

      System.out.println("Delete henry");
      studentRepository.deleteById(2L);

      System.out.print("Number of students:");
      studentRepository.count();
    };
  }

}
