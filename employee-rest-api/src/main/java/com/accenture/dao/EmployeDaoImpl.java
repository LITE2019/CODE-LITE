package com.accenture.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.accenture.domain.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repositor
public class EmployeDaoImpl implements EmployeeDao{

	@Autowired
	private final SessionFactory sessionFactory;
	public EmployeDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		Long id=null;
		if(employee.getId()==null)
		{
			id = (Long) this.sessionFactory.getCurrentSession().save(employee);
		}
		else
		{
			this.sessionFactory.getCurrentSession().update(employee);
			id=employee.getId();
		}
		return this.sessionFactory.getCurrentSession().get(Employee.class, id);
		return null;
	}

	public List<Employee> findTopSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee findById(Long id) {
		return this.sessionFactory.getCurrentSession().get(Employee.class, id);
		return null;
	}

	public Void delete(Long id) {
		Employee em=this.sessionFactory.getCurrentSession().get(Employee.class,id);
		this.sessionFactory.getCurrentSession().delete(em);
		return null;
	}

}
