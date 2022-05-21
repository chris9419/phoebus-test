package com.phoebussoftware.technicalTest.repository;

import com.phoebussoftware.technicalTest.model.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {}
