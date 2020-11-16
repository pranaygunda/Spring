package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.LoginModel;

@RestController
@RequestMapping("/user")
public class LoginController {
	
	List<LoginModel> lm = new ArrayList<LoginModel>();
	LoginController(){
		lm.add(new LoginModel("Pranay","pra"));
		lm.add(new LoginModel("Naresh","nar"));
		lm.add(new LoginModel("Parag","par"));
	}
	
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public ResponseEntity<String> validateData(@RequestBody String name, String pwd){
		boolean b = false;
		for(LoginModel l : lm) {
			if(l.getPwd().equals(pwd) && l.getName().contentEquals(name)) {
				b=true;
				break;
			}
		}
		System.out.println(b ? "Valid User" : "Invalid User");
		return new ResponseEntity(HttpStatus.CREATED);
	}

}
