package com.phoebussoftware.technicalTest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {

  @Id Long accountId;
  Integer accountNumber;

  /* TODO: Options for bidirectional one to many
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id", nullable=false,insertable=false,updatable=false)
  CustomerEntity customerEntity;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
  CustomerEntity customerEntity;
  */
}
