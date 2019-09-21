package com.accenture.service;

import java.util.List;

import com.accenture.domain.Employee;

public interface EmployeeService {
	
	public Employee save(Employee employee);
	public List<Employee> findTopSalary();
	public Employee findById(Long id);
	public Void delete(Long id);

}
