import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class Client{
	private static SessionFactory factory;
	
	
	public static void getSessionFactory() {
		
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory= conf.buildSessionFactory(builder.build()); 
		}
		catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object."+ ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	
	public static void main(String[] args) {
		
		
		try {
			
			getSessionFactory();
			
			Client client_1 = new Client();
			
			client_1.InsertRecordInDatabase(1,"Rohit", "p", 7000);
			client_1.InsertRecordInDatabase(2,"Surya", "N", 5000);
			client_1.InsertRecordInDatabase(3,"Charan", "K", 7000);
			client_1.InsertRecordInDatabase(4,"Chandu", "D", 7000);
			client_1.InsertRecordInDatabase(5,"Hardik", "p", 7000);
			client_1.InsertRecordInDatabase(6,"Rahul", "p", 7000);
			client_1.InsertRecordInDatabase(7,"Bharath", "p", 8000);
			
			System.out.println("Listing employees..");
			client_1.DisplayRecords();
			/*
			
			System.out.println("Updated the record..");
			client_1.UpdateRecord(2, 10000000);
			client_1.DisplayRecords();
			
			System.out.println("Displaying data using Native SQL..");
			client_1.DisplayRecords_NativeSQL();
			
			System.out.println("Deleting the 3rd record...");
			client_1.DeleteRecord(3);
			*/
			client_1.DisplayRecords1();
			
			
		}
		catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		}
	}
		public void InsertRecordInDatabase (int id, String fname, String lname, int salary) throws HibernateException
		{
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			Employee e1 = new Employee(id, fname, lname, salary);
			session.save(e1);
			tx.commit();
			
			session.close();
			
		}
	
	public void DisplayRecords() throws HibernateException{
		Session session = factory.openSession();
		List empList = session.createQuery("FROM Employee").list();
		for (Iterator iterator = empList.iterator(); iterator.hasNext();) {
			System.out.println();
			Employee emp = (Employee) iterator.next();
			System.out.println("ID: " + emp.getId());
			System.out.println("First Name: " + emp.getFirstName());
			System.out.println("Last Name: " + emp.getLastName());
			System.out.println(" Salary: " + emp.getSalary());
		}
		
		session.close();
		
	}

	public void DisplayRecords1() throws HibernateException{
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		cr.add(Restrictions.gt("salary",6000));
		List employees = cr.list();
		System.out.println("Inside DisplayRecords1");
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			System.out.println();
			Employee emp = (Employee) iterator.next();
			System.out.println("ID: " + emp.getId());
			System.out.println("First Name: " + emp.getFirstName());
			System.out.println("Last Name: " + emp.getLastName());
			System.out.println(" Salary: " + emp.getSalary());
		}
		
		session.close();
		
	}

	
	
	public void DisplayRecords_NativeSQL() throws HibernateException
	{
		Session session = factory.openSession();
		String sql = "SELECT * FROM employee where salary > 7000" ;
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Employee.class);
		List results = query.list();
		
		for (Iterator iterator =
				results.iterator(); iterator.hasNext();) {
			Employee emp = (Employee) iterator.next();
			System.out.print("First Name: " + emp.getFirstName());
			System.out.print("Last Name: " + emp.getLastName());
			System.out.print("Salary: " + emp.getSalary());
			
		}
		session.close();
	}
	
	
	public void UpdateRecord(Integer EmpId, int salary) throws HibernateException
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee employee = (Employee )session.get(Employee.class, EmpId);
		employee.setSalary(salary);
		tx.commit();
		
		session.close();
		
	}
	public void DeleteRecord(Integer EmployeeID) throws HibernateException
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee employee = (Employee )session.get(Employee.class, EmployeeID);
		session.delete(employee);
		tx.commit();
		
		session.close();
		
	}
	
	
}