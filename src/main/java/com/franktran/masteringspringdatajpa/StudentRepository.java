package com.franktran.masteringspringdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<Student, Long> {

  @Transactional
  @Modifying
  @Query("DELETE FROM Student s WHERE s.id = ?1")
  int deleteStudentById(Long id);

}
