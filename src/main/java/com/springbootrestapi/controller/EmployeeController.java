package com.springbootrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestapi.exception.ResourceNotFoundException;
import com.springbootrestapi.model.Employee;
import com.springbootrestapi.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/employes")
public class EmployeeController {
	@Autowired
	private EmployeeRepository emprepo;
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return emprepo.findAll();
	}
	
	//build create employee Rest API
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return emprepo.save(employee);
	}
	
	//build get employee by id Rest API
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		Employee e1=emprepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: "+id));
		return ResponseEntity.ok(e1);
	}
	
	//build update employee Rest API
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee empdetails){
		Employee updateEmployee=emprepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: "+id));
		updateEmployee.setFirstname(empdetails.getFirstname());
		updateEmployee.setLastname(empdetails.getLastname());
		updateEmployee.setEmailId(empdetails.getEmailId());
		
		emprepo.save(updateEmployee);
		
		return ResponseEntity.ok(updateEmployee);
	}
	
	//build delete employee Rest API
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
		Employee e1=emprepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: "+id));
		emprepo.delete(e1);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
