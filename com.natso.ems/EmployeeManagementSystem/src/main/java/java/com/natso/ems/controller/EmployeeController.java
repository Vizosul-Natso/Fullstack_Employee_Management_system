package java.com.natso.ems.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.com.natso.ems.entity.Employee;
import java.com.natso.ems.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service ;
		
	@RequestMapping(value = "createEmployee", method = RequestMethod.GET)
	public ModelAndView createEmployee(ModelAndView mav, Employee employee) {
		mav.addObject("employee", employee) ;
		mav.setViewName("form");
		return mav ;
	}

	
	@RequestMapping(value = "saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(ModelAndView mav, @ModelAttribute Employee employee) {
		service.saveEmployee(employee);
		mav.setViewName("index");
		return mav ;
	}
	
	@RequestMapping(value = "findEmployee", method = RequestMethod.GET)
	public ModelAndView findEmployee(ModelAndView mav) {
		mav.setViewName("find");
		return mav ;
	}
	
	@RequestMapping(value = "findingEmployee", method = RequestMethod.GET)
		public ModelAndView findingEmployee(ModelAndView mav, HttpServletRequest request) {
			int id = Integer.parseInt(request.getParameter("id") ) ;
			Employee obj = service.findEmployee(id) ;
			mav.addObject("employee", obj) ;
			mav.setViewName("show"); 
			return mav ;
	}
	
	@RequestMapping(value = "deleteEmployee", method = RequestMethod.GET)
		public ModelAndView deleteEmployee(ModelAndView mav) {
		mav.setViewName("delete");
		return mav ;
	}
	
	@RequestMapping(value = "deletingEmployee", method = RequestMethod.GET)
		public ModelAndView deletingEmployee(ModelAndView mav, HttpServletRequest request) {
			int id = Integer.parseInt(request.getParameter("id") ) ;
		     boolean flag = service.deletEmployee(id) ;
		     
		     if (flag) {
				mav.addObject("msg", "Deletd Successfully...!") ;
				mav.setViewName("index");
				return mav ;
			}
		     else {
		    	 mav.addObject("msg", "Unable to Delete Employee") ;
				 mav.setViewName("index");
				return mav ;
		     }
	 }
	
	@RequestMapping(value = "updateEmployee", method = RequestMethod.GET)
	public ModelAndView updateEmployee(ModelAndView mav) {
		mav.setViewName("update");
		return mav ;
	}
	
	@RequestMapping(value = "updatingEmployee", method = RequestMethod.GET)
	public ModelAndView updatingEmployee(ModelAndView mav, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id") ) ;
		Employee employee = service.findEmployee(id) ;
		mav.addObject("updateEmployee", employee) ;
		mav.setViewName("updating");
		return mav ;
	}
	
	@RequestMapping(value = "saveUpdateEmployee", method = RequestMethod.POST)
	public ModelAndView savingUpdatedEmployee(ModelAndView mav, @ModelAttribute Employee jeevith) {
		
		service.updateEmployee(jeevith);
		mav.setViewName("index");
		return mav ;
	}
	
	@RequestMapping(value = "displayAll", method =  RequestMethod.GET)
	public ModelAndView displayAll(ModelAndView mav) {
		
		List<Employee> list = service.displayAll() ;
		
		System.out.println(list);
		
		for(Employee p : list) {
			System.out.println(p);
		}
		
		
		mav.setViewName("index");
		return mav ;
	}
	

}