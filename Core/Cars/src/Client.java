import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	public static void main(String args[])
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("helloBean.xml");
		Carbase obj=(Carbase)context.getBean("hello");
		BMWCar obj1=(BMWCar)context.getBean("hellobmw");
		Mercedes obj2=(Mercedes)context.getBean("hellomer");
		System.out.println("Car Details");
		obj1.display();
		System.out.println("Car Details");
		obj2.display();
		
		
	}

}
