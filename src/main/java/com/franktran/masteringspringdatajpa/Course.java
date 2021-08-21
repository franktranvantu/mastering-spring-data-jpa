package com.franktran.masteringspringdatajpa;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "course")
public class Course {

  @Id
  @SequenceGenerator(
      name = "course_sequence",
      sequenceName = "course_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = SEQUENCE,
      generator = "course_sequence"
  )
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "name", columnDefinition = "TEXT", nullable = false)
  private String name;

  @Column(name = "department", columnDefinition = "TEXT", nullable = false)
  private String department;

  public Course() {
  }

  public Course(String name, String department) {
    this.name = name;
    this.department = department;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  @Override
  public String toString() {
    return "Course{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", department='" + department + '\'' +
        '}';
  }
}
