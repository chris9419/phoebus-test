package com.phoebussoftware.technicalTest.service;


import com.phoebussoftware.technicalTest.DTO.CustomerDTO;
import com.phoebussoftware.technicalTest.model.CustomerEntity;

public interface ICustomerService {

    CustomerEntity convertToEntity(CustomerDTO customerDTO);

    CustomerDTO convertToDTO(CustomerEntity customerEntity);

    CustomerEntity saveCustomer(CustomerEntity customerEntity);
}
