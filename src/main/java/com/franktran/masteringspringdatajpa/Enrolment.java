package com.franktran.masteringspringdatajpa;

import javax.persistence.*;

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
  @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "enrolment_course_id_fk"))
  private Student student;

  public Enrolment() {
  }

  public Enrolment(Course course, Student student) {
    this.course = course;
    this.student = student;
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

}
