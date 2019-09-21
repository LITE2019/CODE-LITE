package com.accenture.controller;

import com.accenture.domain.Employee;
import com.accenture.rest.Autowired;

import com.accenture.rest.RestController;
import com.accenture.service.EmployeeService;

import com.accentute.rest.RequestMapping;
import com.accentute.rest.DeleteMapping;
import com.accentute.rest.GetMapping;
import com.accentute.rest.PathVariable;
import com.accentute.rest.PostMapping;
import com.accentute.rest.PutMapping;
import com.accentute.rest.RequestBody;
import com.accentute.rest.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class RestController {
	
	private static final String Dto="employee";
	@Autowired
	private final EmployeeService employeeService;
	public RestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	// save employees details
	@PostMapping("/employee")
	public ResponseEntity<Employee> save(@Valid @RequestBody  Employee employee) throws Exception
	{
		if(employee.getId()!=null)
		{
			throw new Exception("Employee already exist");
		}
		Employee result=employeeService.save(employee);
		return ResponseEntity.created(new URI("/api/employee")).header(Dto, result.getId().toString()).body(result);
	}
	
	//Getting employees as per ID
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> findById(@PathVariable Long id) throws URISyntaxException
	{
		Employee result=this.employeeService.findById(id);
		return ResponseEntity.ok().header(Dto, result.getId().toString()).body(result);
	}

	//Delete resigned employee by id
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> delete(@PathVariable Long id)
	{
		this.employeeService.delete(id);
		return ResponseEntity.ok().header(Dto, id.toString()).build();
	}
	
}
