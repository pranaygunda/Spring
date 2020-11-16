package com.sunsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunsoft.dao.CustomerDao;

import com.sunsoft.model.CustomerData;


@RestController
public class CustomerController {
	
	@Autowired
	CustomerDao CustomerDao;
	
	@RequestMapping ("/insert")
	public String insertData()
	{
		CustomerData sobj = new CustomerData();
		sobj.setId(110);
		sobj.setName("Pranay Gunda");
		sobj.setTenure(10);
		sobj.setAmount(100000);
		
		CustomerData sobj2 = new CustomerData();
		sobj.setId(111);
		sobj.setName("Naresh Bojja");
		sobj.setTenure(5);
		sobj.setAmount(500000);
		
		
		CustomerDao.insertData(sobj);
		CustomerDao.insertData(sobj2);
		
		return "Data insertion is successful";
	}

	
	@RequestMapping("/delete/{id}")
	public String deleteData(@PathVariable("id") int id)
	{
		CustomerDao.deleteRecord(id);
		return "Record deletion successful";
	}
	
	
	@RequestMapping("/displayAll")
	public List<CustomerData> displayData()
	{
		List<CustomerData> studentList = CustomerDao.displayAll();
		return studentList;
	}

}
