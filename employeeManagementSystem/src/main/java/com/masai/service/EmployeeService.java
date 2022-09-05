package com.masai.service;

import java.util.List;

import com.masai.entities.Employee;
import com.masai.exception.EmployeeException;

public interface EmployeeService {
	
	public Employee addEmployee(Employee emp) throws EmployeeException ;
	
	public List<Employee> getAllEmployee() throws EmployeeException;
	
	public String updateEmployee(Integer id, Employee emp) throws EmployeeException;
	
	public Employee deleteEmployee(Integer id) throws EmployeeException;
	
	public List<Employee> getAllEmployeeByDept(Integer Id) throws EmployeeException;

}
