package com.accenture.service;

import java.util.List;

import com.accenture.dao.EmployeeDao;
import com.accenture.domain.Employee;
import com.accenture.service.Autowired;
import com.accenture.service.Service;
import com.accenture.service.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private final EmployeeDao employeeDao;
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public Employee save(Employee employee) {
		return this.save(employee);
	}

	public List<Employee> findTopSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee findById(Long id) {
		return this.findById(id);
	}

	public Void delete(Long id) {
		return this.delete(id);
	}

}
