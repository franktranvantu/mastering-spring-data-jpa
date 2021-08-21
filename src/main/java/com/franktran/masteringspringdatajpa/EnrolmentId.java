package com.franktran.masteringspringdatajpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EnrolmentId implements Serializable {

  @Column(name = "course_id", nullable = false)
  private Long courseId;

  @Column(name = "student_id", nullable = false)
  private Long studentId;

  public EnrolmentId() {
  }

  public EnrolmentId(Long courseId, Long studentId) {
    this.courseId = courseId;
    this.studentId = studentId;
  }

  public Long getCourseId() {
    return courseId;
  }

  public void setCourseId(Long courseId) {
    this.courseId = courseId;
  }

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EnrolmentId that = (EnrolmentId) o;
    return Objects.equals(courseId, that.courseId) && Objects.equals(studentId, that.studentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courseId, studentId);
  }

}
