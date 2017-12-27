package manyToMany;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class Loading {
	
	public static void main(String[] args) {
		
		
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory =configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria ctr=session.createCriteria(Department.class);
		
		ctr.add(Restrictions.eq("departmentName", "Marketing"));		
		List<Department> orders=ctr.list();	
		for(Department order : orders)
		{
			System.out.println("DEPT ID : "+order.getDepartmentId()+ " ");
			System.out.println("DEPT NAME : "+order.getDepartmentName());
			
		}
		
		
		Criterion departmentName = Restrictions.eq("departmentName", "Marketing");
		Criterion departmentId = Restrictions.eq("departmentId", 7L);
		
		Criterion criterion = Restrictions.or(departmentName, departmentId);
		ctr.add(criterion);
		
		List<Department> departments = ctr.list();
		for(Department department : departments){
			
			System.out.println(department.getDepartmentName());
			System.out.println(department.getDepartmentId());
		}
		System.out.println("============");
		
		
		
		
		Criterion criterion1 = Restrictions.and(departmentName, departmentId);
		ctr.add(criterion1);
		
		List<Department> departments1 = ctr.list();
		for(Department department : departments1){
			
			System.out.println(department.getDepartmentName());
			System.out.println(department.getDepartmentId());
		}
		
	}

}
