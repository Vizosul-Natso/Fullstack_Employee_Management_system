package java.com.natso.ems.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.com.natso.ems.entity.*;

@Component
public class Dao {

	@Autowired
	private EntityManager entityManager ;
	
	public void saveEmployee(Employee employee) {
		
		EntityTransaction transaction = entityManager.getTransaction() ;
		transaction.begin();
		entityManager.persist(employee);
		transaction.commit();
//		entityManager.close();
	}
	
	public Employee findEmployee(int id) {
			return entityManager.find(Employee.class, id) ;
	}
	
	public boolean deleteEmployee(int id) {
		
		Employee employee = findEmployee(id) ;
		
		if (employee != null) {
			EntityTransaction transaction = entityManager.getTransaction() ;
			transaction.begin();
			entityManager.remove(employee);
			transaction.commit();
			entityManager.close();
			return true ;
		}
		return false ;
		
	}
	
	public void updateEmployee(Employee employee) {
		
		EntityTransaction transaction = entityManager.getTransaction() ;
		transaction.begin();
		entityManager.merge(employee) ;
		transaction.commit();
	}
	
	public List<Employee> displayAll() {
		
		Query query = entityManager.createQuery("from Employee") ;
		
		List list = query.getResultList() ;
		
		return list ;
				
	}
}