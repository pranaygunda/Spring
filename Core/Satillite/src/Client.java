import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Client {
	public static void main(String args[])
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("helloBean.xml");
		SatilliteClass obj=(SatilliteClass)context.getBean("hello");
		System.out.println("Satillite Details");
		obj.display();
		((AbstractApplicationContext) context).registerShutdownHook();
	}

}
