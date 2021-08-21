package com.franktran.masteringspringdatajpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EnrolmentId {

  @Column(name = "course_id", nullable = false)
  private Long courseId;

  @Column(name = "student_id", nullable = false)
  private Long studentId;

}
