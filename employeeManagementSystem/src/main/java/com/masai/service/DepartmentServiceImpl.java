package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Department;
import com.masai.exception.DepartmentException;
import com.masai.repository.DepartmentDao;

//@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDao dDao;

	@Override
	public Department addDepartment(Department dept) throws DepartmentException {
		
		return dDao.save(dept);
	}

}
