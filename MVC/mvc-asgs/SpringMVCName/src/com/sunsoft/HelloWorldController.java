package com.sunsoft;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/login")
	public String helloWorld(HttpServletRequest request,HttpServletResponse res,Model m) 
	{
		String name=request.getParameter("name");
		
		String message="Welcome "+name;
		m.addAttribute("message",message);
		System.out.println(message);
		return "hellopage";
			
		}
		
	

}
