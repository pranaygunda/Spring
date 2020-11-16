package com.sunsoft;
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  

@Controller  
public class HelloWorldController {
	 List<InsuranceDomain> list=new ArrayList<InsuranceDomain>();  
	 
	 
	
	@RequestMapping("/add")  
    public String showform(Model m){  
        m.addAttribute("command",new InsuranceDomain());
        return("add");  
    }  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("ins") InsuranceDomain ins,Model m){  
        
        System.out.println(ins.getId()+" "+ins.getName()+" "+ins.getType()+" "+ins.getAmount());
       
           list.add(ins);
           m.addAttribute("message","Details Added");
           return "file";
        
    }  
      
    @RequestMapping("/view")  
    public String view(Model m){  
        
       
      
        m.addAttribute("list",list);
        
        for(InsuranceDomain i:list)
        System.out.println(i.id+" "+i.name+" "+i.type+" "+i.amount);
        return "view";  
    }  
    public int getListSize() { 
    	return list.size(); 
    	}
    
}  


