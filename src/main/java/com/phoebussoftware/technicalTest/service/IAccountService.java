package com.phoebussoftware.technicalTest.service;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.model.AccountEntity;

public interface IAccountService {

    AccountEntity convertToEntity(AccountDTO accountDTO);

    AccountDTO convertToDTO(AccountEntity accountEntity);

    AccountEntity saveAccount(AccountEntity accountEntity);
}
