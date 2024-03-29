package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	@Autowired
	public EmployeeServiceImpl( EmployeeRepository theEmployeeRepository) {
		employeeRepository=theEmployeeRepository;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee=null;
		if(result.isPresent()) {
			theEmployee=result.get();
		}else {
			throw new RuntimeException("Unable to find Id -" +theEmployee);
		}
		return theEmployee;
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
	
		employeeRepository.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		
		employeeRepository.deleteById(theId);
	}

}
