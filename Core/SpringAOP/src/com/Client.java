package com;

import javax.annotation.Resource;
import test.CustomerService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Client {
	public static void main(String args[]) {
		
		ClassPathResource r=new ClassPathResource("Beans.xml");
		BeanFactory factory=new XmlBeanFactory(r);
		CustomerService cs=(CustomerService)factory.getBean("customerServiceProxy",CustomerService.class);
		cs.printName();
		System.out.println();
		cs.printUrl();
		
		
		
	}

}
