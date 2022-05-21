package com.phoebussoftware.technicalTest.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {

  Long customerId;

  @NotNull(message = "foreName has to be present")
  String foreName;

  @NotNull(message = "surName has to be present")
  String surName;

  @NotNull(message = "dataOfBirth has to be present")
  Date dataOfBirth;

  List<AccountDTO> accountDTOS;
}
