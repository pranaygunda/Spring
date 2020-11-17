package com.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/name")
public class NameController {
	
	@RequestMapping(value="/{firstName}/{lastName}", method=RequestMethod.GET)
	public String validateUser(@PathVariable String firstName, @PathVariable String lastName) {
		if(firstName=="Pranay" && lastName == "Gunda") {
		System.out.println(firstName+" "+lastName);
		return firstName+" "+lastName;
	}
		else
		return "Invalid User";
	}
}