package com.phoebussoftware.technicalTest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {

  @Id Long customerId;
  String foreName;
  String surName;
  Date dataOfBirth;


  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
  List<AccountEntity> accountEntities;

//  @OneToMany( cascade = CascadeType.ALL)
//  @JoinColumn(name = "customer_id", nullable=false)
//  List<AccountEntity> accountEntities;

}
