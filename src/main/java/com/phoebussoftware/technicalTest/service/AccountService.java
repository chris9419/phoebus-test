package com.phoebussoftware.technicalTest.service;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.DTO.CustomerDTO;
import com.phoebussoftware.technicalTest.model.AccountEntity;
import com.phoebussoftware.technicalTest.model.CustomerEntity;
import com.phoebussoftware.technicalTest.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements IAccountService{
    AccountRepository accountRepository;
    ModelMapper modelMapper;
    public AccountService(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AccountEntity convertToEntity(AccountDTO accountDTO) {

        return modelMapper.map(accountDTO, AccountEntity.class);

        /* TODO:In case of bidirectional one to many
        AccountEntity accountEntity = new AccountEntity();
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setCustomerId(accountDTO.getCustomerDTO().getCustomerId());
        customerEntity.setForeName(accountDTO.getCustomerDTO().getForeName());
        customerEntity.setSurName(accountDTO.getCustomerDTO().getSurName());
        customerEntity.setDataOfBirth(accountDTO.getCustomerDTO().getDataOfBirth());

        List<AccountEntity> accountEntityList = new ArrayList<>();
        for (AccountDTO dto : accountDTO.getCustomerDTO().getAccountDTOS()) {
            AccountEntity tempAccountEntity = new AccountEntity();

            accountEntity.setAccountId(dto.getAccountId());
            accountEntity.setAccountNumber(dto.getAccountNumber());
            accountEntityList.add(tempAccountEntity);

        }
        customerEntity.setAccountEntities(accountEntityList);

        accountEntity.setCustomerEntity(customerEntity);
        accountEntity.setAccountId(accountDTO.getAccountId());
        accountEntity.setAccountNumber(accountDTO.getAccountNumber());

        return accountEntity;
        */

    }

    @Override
    public AccountDTO convertToDTO(AccountEntity accountEntity) {

        return modelMapper.map(accountEntity, AccountDTO.class);

        /* TODO: In case of bidirectional one to many
        AccountDTO accountDTO = new AccountDTO();
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setCustomerId(accountEntity.getCustomerEntity().getCustomerId());
        customerDTO.setForeName(accountEntity.getCustomerEntity().getForeName());
        customerDTO.setSurName(accountEntity.getCustomerEntity().getSurName());
        customerDTO.setDataOfBirth(accountEntity.getCustomerEntity().getDataOfBirth());

        List<AccountDTO> accountDTOS = new ArrayList<>();
        for (AccountEntity entity : accountEntity.getCustomerEntity().getAccountEntities()) {
            AccountDTO tempAccountDTO = new AccountDTO();

            accountDTO.setAccountId(entity.getAccountId());
            accountDTO.setAccountNumber(entity.getAccountNumber());
            accountDTOS.add(tempAccountDTO);

        }

        customerDTO.setAccountDTOS(accountDTOS);

        accountDTO.setCustomerDTO(customerDTO);
        accountDTO.setAccountId(accountEntity.getAccountId());
        accountDTO.setAccountNumber(accountEntity.getAccountNumber());

        return accountDTO;
        */

    }

    @Override
    public AccountEntity saveAccount(AccountEntity accountEntity) {
        return accountRepository.save(accountEntity);
    }
}
