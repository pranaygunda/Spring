package com.sunsoft;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/login")
	public String helloWorld(HttpServletRequest request,HttpServletResponse res,Model m) {
		int id=Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("password");
		if(password.equals("pranay")) {
			Employee e=new Employee();
			e.setId(id);
			e.setName("pranay");
			e.setDept("IBGT");
			e.setDesignation("Senior Officer");
			m.addAttribute("Employee",e);
			System.out.println(e.id+" "+e.name+" "+e.dept+" "+e.designation);
			return "hellopage";
			
		}
		else {
			String message="Sorry Invalid Username or password";
			m.addAttribute("message",message);
			return "errorpage";
		}
	}

}
