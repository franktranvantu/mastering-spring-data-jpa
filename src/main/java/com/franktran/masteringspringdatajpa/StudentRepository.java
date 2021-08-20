package com.franktran.masteringspringdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

  @Query(value = "SELECT * FROM student WHERE email = ?1", nativeQuery = true)
  Optional<Student> findStudentByEmail(String email);

  @Query(value = "SELECT * FROM Student WHERE first_name = ?1 AND age >= ?2", nativeQuery = true)
  List<Student> findStudentsByFirstNameEqualsAndAgeGreaterThanEqual(String firstName, Integer age);

}
