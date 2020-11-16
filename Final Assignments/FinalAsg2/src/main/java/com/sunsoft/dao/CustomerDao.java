package com.sunsoft.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunsoft.model.CustomerData;
import com.sunsoft.repository.CustomerRepo;


@Service
public class CustomerDao {

	
	@Autowired
	CustomerRepo cRepo;
	public void insertData(CustomerData studentObj)
	{
		cRepo.save(studentObj);
	}

	public void deleteRecord(int id)
	{
		cRepo.deleteById(id);
	}
	public List<CustomerData> displayAll()
	{
		List<CustomerData> studentList = (List<CustomerData>) cRepo.findAll();
		return studentList;
	}
	

}


