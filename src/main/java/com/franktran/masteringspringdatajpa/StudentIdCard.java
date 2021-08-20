package com.franktran.masteringspringdatajpa;

import javax.persistence.*;

@Entity
@Table(
    name = "student_id_card",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "student_id_card_number_unique",
            columnNames = "card_number"
        )
    }
)
public class StudentIdCard {

  @Id
  @SequenceGenerator(
      name = "student_id_card_sequence",
      sequenceName = "student_id_card_sequence",
      allocationSize = 1
  )
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_card_sequence")
  @Column(
      name = "id",
      updatable = false
  )
  private Long id;

  @Column(
      name = "card_number",
      columnDefinition = "TEXT",
      length = 15,
      nullable = false
  )
  private String cardNumber;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(
      name = "student_id",
      referencedColumnName = "id"
  )
  private Student student;

  public StudentIdCard() {
  }

  public StudentIdCard(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

}
