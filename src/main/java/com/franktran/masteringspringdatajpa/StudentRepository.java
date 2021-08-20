package com.franktran.masteringspringdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

  Optional<Student> findStudentByEmail(String email);

  List<Student> findStudentsByFirstNameEqualsAndAgeEquals(String firstName, Integer age);

  List<Student> findStudentsByLastNameStartsWithAndAgeGreaterThanEqual(String lastName, Integer age);

}
