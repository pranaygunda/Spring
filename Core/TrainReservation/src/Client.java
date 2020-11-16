import java.util.Scanner;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	public static void main(String args[])
	{
		ArrayList<Train> train=new ArrayList<Train>();
		Train obj1=new Train();
		Train obj2=new Train();
		Train obj3=new Train();
		Train obj4=new Train();
		obj1.setName("sowmya");
		obj1.setEmail("sowmya@gmail.com");
		obj1.setLocation("Hyderabad");
		obj1.setTrainname("Garibrath");
		
		obj2.setName("sushma");
		obj2.setEmail("sushma@gmail.com");
		obj2.setLocation("Vizag");
		obj2.setTrainname("Venkatadri");
		
		obj3.setName("Priya");
		obj3.setEmail("priya@gmail.com");
		obj3.setLocation("Mumbai");
		obj3.setTrainname("Garibrath");
		
		obj4.setName("keerthi");
		obj4.setEmail("keerthi@gmail.com");
		obj4.setLocation("Chennai");
		obj4.setTrainname("Narayanadri");
		train.add(obj1);
		train.add(obj2);
		train.add(obj3);
		train.add(obj4);
		for(Train i: train){
			System.out.println(i.name+" "+i.email+" "+i.location+" "+i.trainname);
	   }
		
	}

}
