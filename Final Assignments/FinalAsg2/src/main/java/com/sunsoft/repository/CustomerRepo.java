package com.sunsoft.repository;

import org.springframework.data.repository.CrudRepository;

import com.sunsoft.model.CustomerData;


public interface CustomerRepo extends CrudRepository<CustomerData , Integer>
{

}
