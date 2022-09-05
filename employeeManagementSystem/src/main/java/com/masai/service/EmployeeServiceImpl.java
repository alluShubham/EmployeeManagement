package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Department;
import com.masai.entities.Employee;
import com.masai.exception.EmployeeException;
import com.masai.repository.DepartmentDao;
import com.masai.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao eDao;
	
	@Autowired
	private DepartmentDao dDao;
	
//	@Autowired
//	private DepartmentServiceImpl  dService;

	@Override
	public Employee addEmployee(Employee emp) throws EmployeeException {
		Department dt = new Department();
		dt.getEmp().add(emp);
		dDao.save(dt);
//		dService.addDepartment(dt);
		
		return eDao.save(emp);
		
		
	}

	@Override
	public List<Employee> getAllEmployee() throws EmployeeException {
		List<Employee> emps = eDao.findAll();
		if(emps.size()>0) {
			return emps;
		}
		else
			throw new EmployeeException("List not found");
	}

	@Override
	public String updateEmployee(Integer id, Employee emp) throws EmployeeException {
		Optional<Employee> e1 = eDao.findById(id);
		if(e1.isPresent()) {
			eDao.save(emp);
			return "Update";
		}
		else
			throw new EmployeeException("Not updated");
	}

	@Override
	public Employee deleteEmployee(Integer id) throws EmployeeException {
		Optional<Employee> e1 = eDao.findById(id);
		if(e1.isPresent()) {
			eDao.delete(e1.get());
			return e1.get();
		}
		else
			throw new EmployeeException("Not deleted");
	}

	@Override
	public List<Employee> getAllEmployeeByDept(Integer Id) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

}
