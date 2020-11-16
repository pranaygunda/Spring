import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	public static void main(String args[])
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("helloBean.xml");
		Electric obj=(Electric)context.getBean("hello");
		Electric obj1=(Electric)context.getBean("hello");
		
	
		System.out.println("Details of Electric Meter");
		System.out.println("Meter No: "+obj.getMeterno());
		System.out.println("Intitial Reading :"+obj.getInireading());
		System.out.println("Current Reading :"+obj.getCurrentreading());
		System.out.println("Colour :"+obj.getColour());
		System.out.println();
		System.out.println("Details of Electric Meter");
		System.out.println("Meter No: "+obj1.getMeterno());
		System.out.println("Intitial Reading :"+obj1.getInireading());
		System.out.println("Current Reading :"+obj1.getCurrentreading());
		System.out.println("Colour :"+obj1.getColour());
	   }
		
	}


