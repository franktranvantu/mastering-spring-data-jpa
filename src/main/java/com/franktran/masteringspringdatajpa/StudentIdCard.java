package com.franktran.masteringspringdatajpa;

import javax.persistence.*;

@Entity

public class StudentIdCard {

  @Id
  @SequenceGenerator(
      name = "student_id_card",
      sequenceName = "student_id_card",
      allocationSize = 1
  )
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_card")
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
