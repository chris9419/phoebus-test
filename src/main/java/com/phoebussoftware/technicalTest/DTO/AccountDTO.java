package com.phoebussoftware.technicalTest.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {

  Long accountId;
  CustomerDTO customerDTO; // TODO: Is this needed here ?? Is CustomerEntity customerEntity missing from AccountEntity in order to create ManyToOne relationship (bidirectional one to many) ?
  @NotNull(message = "accountNumber has to be present")
  Integer accountNumber;
}
