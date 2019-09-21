package com.accenture.dao;

import java.util.List;

import com.accenture.domain.Employee;

public interface EmployeeDao {
	
	public Employee save(Employee employee);
	public List<Employee> findTopSalary();
	public Employee findById(Long id);
	public Void delete(Long id);

}
