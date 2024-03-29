package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee thEmployee=employeeService.findById(employeeId);
		if(thEmployee==null) {
			throw new RuntimeException("Employee id not found =" +employeeId);
			
		}
		return thEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee thEmployee) {
		employeeService.save(thEmployee);
		return thEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
		public String deleteEmployee(@PathVariable int employeeId) {
		Employee thEmployee=employeeService.findById(employeeId);
		
		if(thEmployee==null) {
			throw new RuntimeException("Employee id not found-" +employeeId);
		}
		employeeService.deleteById(employeeId);
		return "Deleted employee id-" +employeeId;
	}
	
}






















