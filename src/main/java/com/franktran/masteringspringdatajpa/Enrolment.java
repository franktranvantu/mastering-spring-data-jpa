package com.franktran.masteringspringdatajpa;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "enrolment")
public class Enrolment {

  @EmbeddedId
  private EnrolmentId id;

  @ManyToOne
  @MapsId("courseId")
  @JoinColumn(name = "course_id", foreignKey = @ForeignKey(name = "enrolment_course_id_fk"))
  private Course course;

  @ManyToOne
  @MapsId("studentId")
  @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "enrolment_student_id_fk"))
  private Student student;

  @Column(name = "created_at", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE", nullable = false)
  private LocalDateTime createdAt;

  public Enrolment() {
  }

  public Enrolment(Course course, Student student, LocalDateTime createdAt) {
    this.course = course;
    this.student = student;
    this.createdAt = createdAt;
  }

  public Enrolment(EnrolmentId id, Course course, Student student, LocalDateTime createdAt) {
    this.id = id;
    this.course = course;
    this.student = student;
    this.createdAt = createdAt;
  }

  public EnrolmentId getId() {
    return id;
  }

  public void setId(EnrolmentId id) {
    this.id = id;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

}
