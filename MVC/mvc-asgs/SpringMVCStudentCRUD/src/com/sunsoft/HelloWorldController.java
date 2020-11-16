package com.sunsoft;
import java.util.ArrayList;  
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;

import jdk.nashorn.internal.ir.RuntimeNode.Request;  

@Controller  
public class HelloWorldController {
	 List<Student> list=new ArrayList<Student>();
	 
	 @RequestMapping("/add") 
	 public String showform(Model m){  
	        m.addAttribute("command",new Student());
	        return("add");  
	    }  
	    @RequestMapping(value="/save",method = RequestMethod.POST)  
	    public String save(@ModelAttribute("ins") Student ins,Model m){  
	        
	        System.out.println(ins.getId()+" "+ins.getName()+" "+ins.getDept());
	       
	           list.add(ins);
	           m.addAttribute("message","Details Added");
	           return "file";
	        
	    }  
	      
	    @RequestMapping("/view")  
	    public String view(Model m){  
	        
	       
	      
	        m.addAttribute("list",list);
	        
	        for(Student i:list)
	        System.out.println(i.id+" "+i.name+" "+i.dept);
	        return "view";  
	    }  	
	    
	    @RequestMapping(value="/delete")   
	    public String delete(HttpServletRequest request,HttpServletResponse res,Model m){  
	        
	        /*
	        int id=Integer.parseInt(request.getParameter("id1"));
	        for(Student i:list)
	        {
	        	if(i.getId()==id)
	        	{
	        		list.remove(id);
	        		break;
	        	}
	        	
	        }
	        return "view";
	        */
	    	return "delete";
	    }  	

	    @RequestMapping(value="/delete_")   
	    public String delete_(HttpServletRequest request,HttpServletResponse res,Model m){  
	        
	        
	        int id=Integer.parseInt(request.getParameter("id1"));
	        for(int i= 0; i<list.size();i++)
	        {
	        	if(list.get(i).getId()==id)
	        	{
	        		list.remove(i);
	        		break;
	        	}
	        	
	        }
	        m.addAttribute("list",list);
	        return "view";
	        
	    }  	
	    
    
}  


