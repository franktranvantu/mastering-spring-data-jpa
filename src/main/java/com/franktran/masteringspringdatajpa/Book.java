package com.franktran.masteringspringdatajpa;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "book")
public class Book {

  @Id
  @SequenceGenerator(
      name = "book_sequence",
      sequenceName = "book_sequence",
      allocationSize = 1
  )
  @GeneratedValue(strategy = SEQUENCE, generator = "book_sequence")
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "book_name", columnDefinition = "TEXT", nullable = false)
  private String bookName;

  @Column(name = "created_at", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE", nullable = false)
  private LocalDateTime createdAt;

  @ManyToOne
  @JoinColumn(
      name = "student_id",
      referencedColumnName = "id",
      foreignKey = @ForeignKey(name = "book_student_id_fk"),
      nullable = false
  )
  private Student student;

  public Book() {
  }

  public Book(String bookName, LocalDateTime createdAt) {
    this.bookName = bookName;
    this.createdAt = createdAt;
  }

  public Book(String bookName, LocalDateTime createdAt, Student student) {
    this.bookName = bookName;
    this.createdAt = createdAt;
    this.student = student;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", bookName='" + bookName + '\'' +
        ", createdAt=" + createdAt +
        ", student=" + student +
        '}';
  }

}
