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
			cl.Insert(1,"Pranay",12,50000);
			cl.Insert(2,"Sushna",7,60000);
			cl.Insert(3,"Ramesh",5,25000);
			cl.Insert(4,"Nolan",6,7000);
			cl.Insert(5,"Donald",6,8000);
			System.out.println("Deleting the 3rd record");
			//cl.DeleteRecord(5);
			cl.DisplayRecords();
			cl.DisplayRecords_NativeSql();
		}
		catch(HibernateException e) {
			System.out.println("Exception is "+e);
		}
	}
	public void Insert(int no,String name,int tenure,int amount) throws HibernateException{
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Insurance e1=new Insurance(no,name,tenure,amount);
		session.save(e1);
		tx.commit();
		session.close();
		
	}
	public void DisplayRecords() throws HibernateException{
		Session session=factory.openSession();
//		Criteria cr=session.createCriteria(Insurance.class);
//		cr.add(Restrictions.gt("salary", 800));
		//List employee=cr.list();
		List l=session.createQuery("From Insurance").list();
		for(Iterator iterator=
				l.iterator();iterator.hasNext();) {
			Insurance i=(Insurance)iterator.next();
			System.out.println("Name :"+i.getName());
			System.out.println("Tenure :"+i.getTenure());
			System.out.println("Amount :"+i.getAmount());
		}
		session.close();
		
	}
	public void DisplayRecords_NativeSql()throws HibernateException{
		Session session=factory.openSession();
		String sql="select * from insurance where amount>8000";
		SQLQuery query=session.createSQLQuery(sql);
		query.addEntity(Insurance.class);
		List results=query.list();
		for(Iterator iterator=
				results.iterator();iterator.hasNext();) {
			Insurance i=(Insurance)iterator.next();
			System.out.println("Name :"+i.getName());
			System.out.println("Tenure :"+i.getTenure());
			System.out.println("Amount :"+i.getAmount());
		}
		session.close();
		
	}
	public void UpdateRecord(Integer No,int amount)  throws HibernateException{
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Insurance i=(Insurance)session.get(Insurance.class,No);
		i.setAmount(amount);	
		session.update(i);
		tx.commit();
		session.close();
	}
	public void DeleteRecord(Integer No) throws HibernateException{
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Insurance i=(Insurance)session.get(Insurance.class,No);
		session.delete(i);
		tx.commit();
		session.close();
	}

}
