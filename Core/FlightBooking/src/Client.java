import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	public static void main(String args[])
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("helloBean.xml");
		FlightBooking obj=(FlightBooking)context.getBean("hello");
		obj.setName("Sowmya");
		obj.setEmail("sowmyakasarla@dbs.com");
		obj.setFromlocation("India");
		obj.setTolocation("US");
		obj.setSeatsavailable(25);
		System.out.println("Flight Booking Details");
		System.out.println("Name : "+obj.getName());
		System.out.println("Email : "+obj.getEmail());
		System.out.println("From location : "+obj.getFromlocation());
		System.out.println("To location : "+obj.getTolocation());
		System.out.println("available Seats : "+obj.getSeatsavailable());
	}

}
