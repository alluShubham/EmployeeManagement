package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Employee;
import com.masai.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/emp")
	ResponseEntity<Employee> addEmployeeHandler(@RequestBody Employee emp){
		Employee e1= empService.addEmployee(emp);
		
		return new ResponseEntity<Employee>(e1, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/emps")
	ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> e1 = empService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(e1, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/emps/{id}")
	ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Integer id){
		
		Employee e1= empService.deleteEmployee(id);
		
		return new ResponseEntity<Employee>(e1, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/emp/{id}")
	ResponseEntity<String> addEmployeeHandler(@RequestBody Employee emp,
			@PathVariable ("id") Integer id ){
		String e1= empService.updateEmployee(id, emp);
		
		return new ResponseEntity<String>(e1, HttpStatus.ACCEPTED);
		
	}

}
