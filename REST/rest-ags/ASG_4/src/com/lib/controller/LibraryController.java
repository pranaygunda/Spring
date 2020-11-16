package com.lib.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.model.LibraryModel;

@RestController
@RequestMapping("/book")
public class LibraryController {
	
	Map<Integer, LibraryModel> book = new HashMap<Integer,LibraryModel>();
	public LibraryController(){
		book.put(1,new LibraryModel(1,"Python",2010));
		book.put(2,new LibraryModel(2,"DevOps",2015));
		book.put(3,new LibraryModel(3,"C++",2000));
		book.put(4,new LibraryModel(4,"BlockChain",1999));
		book.put(5,new LibraryModel(5,"Angular",2012));
		book.put(6,new LibraryModel(6,"Spring",1980));
	
	}
	
	@RequestMapping("")
	public String getBookDetails() {
		String b = "";
		for (Map.Entry<Integer, LibraryModel> e : book.entrySet()) 
            b+=e.getValue().toString()+"\n";
		return b;
	}
	
	@RequestMapping("/{id}")
	public String getBookDetails(@PathVariable int id) {
		LibraryModel bk = book.get(id);
		return bk.toString();
	}
	
}
