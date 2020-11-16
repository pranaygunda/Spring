package com.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.BookData;

@RestController
@RequestMapping("/book")
public class LibraryController {
	
		BookData b1 = new BookData(1,"Python",2010);
		BookData b2 = new BookData(2,"DevOps",2015);
		BookData b3 = new BookData(3,"C++",2000);
		BookData b4 = new BookData(4,"BlockChain",1999);
		BookData b5 = new BookData(5,"Angular",2012);
		
		BookData b[] = {b1,b2,b3,b4,b5};
	
	
	@RequestMapping("/displayAll")
	public String getBookDetails() {
		String o="";
		 for(BookData b1 : b)
		 {
            o+="id:"+b1.getId()+"\tname"+b1.getName()+"\tyear"+b1.getYear()+"\n";
		 }
		return o;
	}
	 
	@RequestMapping("/{id}")
	public String getBookDetails(@PathVariable int id) {
		String o="";
		for(BookData b1: b)
		{
			if(b1.getId()==id)
			{
				o+="id:"+b1.getId()+"\tname"+b1.getName()+"\tyear"+b1.getYear()+"\n";
				break;
			}
		}
		return o;
	}
	
}
