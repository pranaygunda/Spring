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
	
	List<LoginModel> user = new ArrayList<LoginModel>();
	LoginController(){
		user.add(new LoginModel("Pranay","pra"));
		user.add(new LoginModel("Naresh","nar"));
		user.add(new LoginModel("Parag","par"));
	}
	
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public ResponseEntity<String> validateData(@RequestBody String ip){
		String[] arr = ip.split(" ", 5);
		String name = arr[0]; 
		String pwd = arr[1];
		boolean b = false;
		for(LoginModel u : user) {
			if(u.getName().equals(name) && u.getPwd().equals(pwd) ) {
				b=true;
				break;
			}
		}
		// System.out.println(name+" and "+pwd);
		System.out.println(b ? "Valid User" : "Invalid User");
		return new ResponseEntity(HttpStatus.CREATED);
	}

}
