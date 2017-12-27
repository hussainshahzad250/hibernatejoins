package manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Manager {

	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Department department = new Department();
		department.setDepartmentName("Sales");
		session.save(department);
		
		Department department1 = new Department();
		department1.setDepartmentName("Marketing");
		session.save(department1);
//
//		Employee emp1 = new Employee("Nina", "Mayers", "111");
//		Employee emp2 = new Employee("Tony", "Almeida", "222");
//		Employee emp3 = new Employee("Shahzad", "Hussain", "8285409478");
		Employee emp1 = new Employee("Rahul", "Gupta", "253625455");
		Employee emp2 = new Employee("Surendra", "Kumar", "4343433434");
		Employee emp3 = new Employee("Md", "Alam", "54545454");

		emp1.setDepartment(department);
		emp2.setDepartment(department);
		emp3.setDepartment(department1);

		session.save(emp1);
		session.save(emp2);
		session.save(emp3);

		session.getTransaction().commit();
		System.out.println("done");
		session.close();

	}

}
