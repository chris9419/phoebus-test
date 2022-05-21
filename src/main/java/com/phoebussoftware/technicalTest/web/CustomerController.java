package com.phoebussoftware.technicalTest.web;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.DTO.CustomerDTO;
import com.phoebussoftware.technicalTest.model.CustomerEntity;
import com.phoebussoftware.technicalTest.service.ICustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerController {

  ICustomerService customerService;

  public CustomerController(ICustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/{customerId}")
  public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Integer customerId) {
    return ResponseEntity.ok(CustomerDTO.builder().build());
  }

  @GetMapping("/account/{customerId}")
  public ResponseEntity<List<AccountDTO>> getAccountsByCustomerId(
      @PathVariable Integer customerId) {

    List<AccountDTO> accountDTOS = List.of(AccountDTO.builder().build());
    return new ResponseEntity<>(accountDTOS, HttpStatus.OK);
  }

  @PostMapping("/add")
  ResponseEntity<CustomerDTO> addCustomer(@Valid @RequestBody CustomerDTO customerDTO) {

    CustomerEntity result = customerService.saveCustomer(customerService.convertToEntity(customerDTO));
    return new ResponseEntity<>(customerService.convertToDTO(result), HttpStatus.CREATED);

  }

}
