package manyToMany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LoadManager {
	
	public static void main(String[] args) {
		
		
		Configuration configuration = new Configuration().configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Employee p1 = (Employee) session.load(Employee.class, 11L);
		
		Transaction transaction = session.beginTransaction();
		
		session.delete(p1);
		transaction.commit();
		System.out.println("Deleted");
		session.close();
	}

}
