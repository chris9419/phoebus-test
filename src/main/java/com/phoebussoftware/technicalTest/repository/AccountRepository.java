package com.phoebussoftware.technicalTest.repository;

import com.phoebussoftware.technicalTest.model.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {}
