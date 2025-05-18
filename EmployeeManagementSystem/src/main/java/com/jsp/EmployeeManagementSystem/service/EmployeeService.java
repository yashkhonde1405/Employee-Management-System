package com.jsp.EmployeeManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.EmployeeManagementSystem.dto.Employee;
import com.jsp.EmployeeManagementSystem.repository.EmployeeRepository;

@Service
public class EmployeeService {

	    @Autowired
	    EmployeeRepository repository;
	    
	 // TO INSERT Employee OBJECT INTO DB
	    public String insertEmployee(Employee employee)
	    {
	    	repository.save(employee);
	    	return "Employee details stored sucessfully";
	    }
	    
	 // To retrieve all the employee objects from DB

	    public List<Employee> fetchAllEmployeeDetails()
	    {
	    	return repository.findAll();
	    }
	    
	 // To search & fetch an object based on ID (primary key)
	    
	    public Employee findEmployeeById(int id)
	    {
	    	Optional<Employee> opt = repository.findById(id);
	    	
	    	if(opt.isPresent())
	    	{
	    		return opt.get();
	    	}
	    	else
	    	{
	    		return null;
	    	}
	    }
	    
	    // to delete Employee object from DB 
	    
	    public String deleteEmployeeById(int id)
	    {
	    	Employee employee = findEmployeeById(id);
	    	
	    	if(employee != null)
	    	{
	    		repository.delete(employee);
	    		return "Employee details with ID " + id + " have been deleted successfully.";

			}
			else
			{
				return "Employee details of id:"+id +" doesn't exists";
			}
	    }
	    
	 // to update Employee details (name & company) in  DB based in ID
	    
	    public Employee updateEmployee(int id, String newname, String newcompany)
	    {
             Employee employee = findEmployeeById(id);
	    	
	    	 if(employee != null)
	    	 {
	    		 employee.setName(newname);
	    		 employee.setCompany(newcompany);
	    		 repository.save(employee);
	    		 return employee;
	    	 }
	    	 else
	    		 return null;
	    }
	    
}