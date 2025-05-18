package com.jsp.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.EmployeeManagementSystem.dto.Employee;

@Repository              // its optional even though Spring Data JPA works without it.
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
