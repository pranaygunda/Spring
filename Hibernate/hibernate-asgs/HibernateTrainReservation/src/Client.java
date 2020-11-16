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
	public static void main(String args[]) {
		try {
			getSessionFactory();
			Client cl=new Client();
			cl.Insert(1,"Pranay",22,"Hyd","Goa");
			cl.Insert(2,"Sushna",26,"Hyd","Chennai");
			cl.Insert(3,"Samskruthi",35,"Mumbai","Pune");
			cl.Insert(4,"Monica",15,"Banglore","Assam");
			cl.Insert(5,"Ramesh",55,"Karimnagar","Shimla");
			//cl.DeleteRecord(5);
			System.out.println("Displaying Records Whose age is between 25 to 40");
			cl.DisplayRecords();
			//cl.DisplayRecords_NativeSql();
		}
		catch(HibernateException e) {
			System.out.println("Exception is "+e);
		}
	}
	public void Insert(int id,String name,int age,String fromloc,String toloc) throws HibernateException{
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Train e1=new Train(id,name,age,fromloc,toloc);
		session.save(e1);
		tx.commit();
		session.close();
		
	}
	public void DisplayRecords() throws HibernateException{
		Session session=factory.openSession();
		Criteria cr=session.createCriteria(Train.class);
		cr.add(Restrictions.between("age",25,40));
		List t=cr.list();
		//List l=session.createQuery("From Employee").list();
		for(Iterator iterator=
				t.iterator();iterator.hasNext();) {
			Train e=(Train)iterator.next();
			System.out.println("Name :"+e.getName());
			System.out.println("Age :"+e.getAge());
			System.out.println("From Location :"+e.getFromloc());
			System.out.println("To Location :"+e.getToloc());
		}
		session.close();
		
	}
//	public void DisplayRecords_NativeSql()throws HibernateException{
//		Session session=factory.openSession();
//		String sql="select * from Train where salary>8000";
//		SQLQuery query=session.createSQLQuery(sql);
//		query.addEntity(Employee.class);
//		List results=query.list();
//		for(Iterator iterator=
//				results.iterator();iterator.hasNext();) {
//			Employee emp=(Employee)iterator.next();
//			System.out.println("FirstName :"+emp.getFirstname());
//			System.out.println("LastName :"+emp.getLastname());
//			System.out.println("Salary :"+emp.getSalary());
//		}
//		session.close();
//		
//	}
	public void UpdateRecord(Integer Id,String fromloc,String toloc)  throws HibernateException{
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Train t=(Train)session.get(Train.class,Id);
		t.setFromloc(fromloc);
		t.setToloc(toloc);
		session.update(t);
		tx.commit();
		session.close();
	}
	public void DeleteRecord(Integer ID) throws HibernateException{
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Train t=(Train)session.get(Train.class,ID);
		session.delete(t);
		tx.commit();
		session.close();
	}

}
