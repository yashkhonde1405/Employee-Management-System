package com.jsp.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.EmployeeManagementSystem.dto.Employee;
import com.jsp.EmployeeManagementSystem.service.EmployeeService;

@RestController
public class EmployeeController {

	    @Autowired
	    EmployeeService service;
	    
	 // REST API TO STORED Employee OBJECT INTO DB
	    @PostMapping("/employee")
	    public String addEmployee(@RequestBody Employee employee)
	    {
	    	return service.insertEmployee(employee);
	    }
	    
	 // REST API TO RETRIEVE ALL THE Employee OBJECT FROM THE DB   
	    @GetMapping("/employee")
	    public List<Employee> getEmployeeDetails()
	    {
	    	return service.fetchAllEmployeeDetails();
	    }
	    
	 // Rest API to retrieve a specific Employee object from DB
	    
	    @GetMapping("/byid")
	    public Employee getEmployeeDetailsById(@RequestParam int id)
	    {
	    	return service.findEmployeeById(id);
	    }
	    
	 // Rest API to Delete a Employee object from DB 
	    
	    @DeleteMapping("/employee")
	    public String deleteEmployeeDetailsById(@RequestParam int id)
	    {
	    	return service.deleteEmployeeById(id);
	    }
	    
	 // Rest API to Update Employee Details
	    
	    @PutMapping("/employee")
	    public Employee updateEmployeeDetails(@RequestParam int id,
	    		@RequestParam String name, @RequestParam String company)
	    {
	    	return service.updateEmployee(id, name, company);
	    }
}
