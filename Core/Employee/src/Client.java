import java.util.Scanner;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Client {
	public static void main(String args[])
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("helloBean.xml");
		EmployeeDetails obj=(EmployeeDetails)context.getBean("hello");
		ArrayList<EmployeeDetails> emp=new ArrayList<EmployeeDetails>();
		EmployeeDetails obj1=new EmployeeDetails();
		EmployeeDetails obj2=new EmployeeDetails();
		EmployeeDetails obj3=new EmployeeDetails();
		obj1.setId(1);
		obj1.setName("sowmya");
		obj1.setSalary(61000);
		obj2.setId(2);
		obj2.setName("Keerthi");
		obj2.setSalary(10000);
		obj3.setId(3);
		obj3.setName("Priya");
		obj3.setSalary(51000);
		emp.add(obj1);
		emp.add(obj2);
		emp.add(obj3);
		for(EmployeeDetails i: emp){
			if(i.salary>50000)
			System.out.println(i.id+" "+i.name+" "+i.salary);
	   }
		
	}

}
