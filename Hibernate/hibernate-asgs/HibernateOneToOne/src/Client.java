import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Client {
private static SessionFactory factory;
	
	public static void getSessionFactory() {
		 
		try {
			Configuration conf=new Configuration().configure();
			
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory=conf.buildSessionFactory(builder.build());
		}
		catch(Throwable ex) {
			System.err.println("Failed to create session factory object. "+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static void main(String args[])throws InterruptedException{
		getSessionFactory();
		Client cl=new Client();
		Address add1=new Address("Vijaysreecolony","Hyderabad","Telangana","500009");
		Employee emp1=new Employee(3,"Pranay","Gunda",60000);
		emp1.setAddress(add1);
		cl.insertData(emp1,add1);
		
		Address add2=new Address("Sindhicolony","Secunderabad","Telangana","500003");
		Employee emp2=new Employee(4,"Naresh","Bojja",5000);
		emp2.setAddress(add2);
		cl.insertData(emp2,add2);
		
		cl.displayRecords();
	}
	public void insertData(Employee empobj,Address addobj) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(empobj);
		session.save(addobj);
		tx.commit();
		System.out.println("Employee and Address are added into database");
		session.close();	
	}
	public void displayRecords()throws InterruptedException{
		Session session=factory.openSession();
		List results=session.createQuery("FROM Employee").list();
		for(Iterator iterator=
				results.iterator();iterator.hasNext();) {
			Employee emp=(Employee)iterator.next();
			System.out.println("FirstName :"+emp.getFirstname());
			System.out.println("LastName :"+emp.getLastname());
			System.out.println("Salary :"+emp.getSalary());
			Address add=emp.getAddress();
			System.out.println("Address :");
			System.out.print("Street :"+add.getStreet());
			System.out.print("\tCity :"+add.getCity());
			System.out.print("\tState :"+add.getState());
			System.out.print("\tZipCode :"+add.getZipcode());
			System.out.println();
		}

}
}