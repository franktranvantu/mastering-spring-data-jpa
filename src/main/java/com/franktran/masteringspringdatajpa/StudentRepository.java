package com.franktran.masteringspringdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

  @Query(value = "SELECT s FROM Student s WHERE s.email = :email")
  Optional<Student> findStudentByEmail(@Param("email") String email);

  @Query(value = "SELECT * FROM Student WHERE first_name = :firstName AND age >= :age", nativeQuery = true)
  List<Student> findStudentsByFirstNameEqualsAndAgeGreaterThanEqual(
      @Param("firstName") String firstName,
      @Param("age") Integer age
  );

}
