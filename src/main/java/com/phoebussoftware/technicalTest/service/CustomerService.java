package com.phoebussoftware.technicalTest.service;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.DTO.CustomerDTO;
import com.phoebussoftware.technicalTest.model.AccountEntity;
import com.phoebussoftware.technicalTest.model.CustomerEntity;
import com.phoebussoftware.technicalTest.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    CustomerRepository customerRepository;
    ModelMapper modelMapper;
    public CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerEntity convertToEntity(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setCustomerId(customerDTO.getCustomerId());
        customerEntity.setDataOfBirth(customerDTO.getDataOfBirth());
        customerEntity.setForeName(customerDTO.getForeName());
        customerEntity.setSurName(customerDTO.getSurName());
        List<AccountEntity> accountEntityList = new ArrayList<>();
        for (AccountDTO dto : customerDTO.getAccountDTOS()) {
            AccountEntity accountEntity = new AccountEntity();

            accountEntity.setAccountId(dto.getAccountId());
            accountEntity.setAccountNumber(dto.getAccountNumber());
            accountEntityList.add(accountEntity);

        }
        customerEntity.setAccountEntities(accountEntityList);

        return customerEntity;
    }

    @Override
    public CustomerDTO convertToDTO(CustomerEntity customerEntity) {
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setCustomerId(customerEntity.getCustomerId());
        customerDTO.setDataOfBirth(customerEntity.getDataOfBirth());
        customerDTO.setForeName(customerEntity.getForeName());
        customerDTO.setSurName(customerEntity.getSurName());
        List<AccountDTO> accountDTOS = new ArrayList<>();
        for (AccountEntity entity : customerEntity.getAccountEntities()) {
            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setAccountId(entity.getAccountId());
            accountDTO.setAccountNumber(entity.getAccountNumber());
            accountDTOS.add(accountDTO);
        }
        customerDTO.setAccountDTOS(accountDTOS);


        return customerDTO;
    }

    @Override
    public CustomerEntity saveCustomer(CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }
}
