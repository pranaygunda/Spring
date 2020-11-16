import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	public static void main(String args[])
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("helloBean.xml");
		Insurance obj=(Insurance)context.getBean("hello");
		System.out.println("Insurance Domain Details");
		System.out.println("Id : "+obj.getInsuranceid());
		System.out.println("Name : "+obj.getName());
		System.out.println("Insurance Type : "+obj.getType());
		System.out.println("Amount : "+obj.getAmmount());
	}

}
