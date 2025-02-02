package java.com.natso.ems.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import java.com.natso.ems.dao.Dao;
import java.com.natso.ems.entity.Employee;

@org.springframework.stereotype.Service
public class EmployeeService {
	
	
	private Dao dao;
	
	@Autowired
	public EmployeeService(Dao dao) {
		this.dao = dao;
	}
	
	public void saveEmployee(Employee employee) {
		
		if (employee != null) {
			dao.saveEmployee(employee);
		}
	}
	
	public Employee findEmployee(int id) {
		Employee obj = dao.findEmployee(id) ;
		
		if (obj != null) {
			return obj ;
		}
		return null ;
	}
	
	public boolean deletEmployee(int id) {
		
		Employee employee = findEmployee(id) ;
		
		if (employee != null) {
			
			return dao.deleteEmployee(id) ;
		}
		return false ;
	}
	
	public void updateEmployee(Employee employee) {
		
		int id = employee.getId() ;
		
		Employee employee2 = findEmployee(id) ;
		
		if (employee2 != null && employee != null) {
			
			dao.updateEmployee(employee);
		}
	}
	
	public List<Employee> displayAll(){
		return dao.displayAll() ;
	}
}
