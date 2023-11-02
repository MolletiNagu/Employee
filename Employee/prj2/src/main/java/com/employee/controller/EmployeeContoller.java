package com.employee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.model.EmployeeTaxDetails;
import com.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeContoller {

	@Autowired
	private EmployeeService service;

	@GetMapping("/empTaxCalculation/{id}")
	public EmployeeTaxDetails taxCalculation(@PathVariable int id) {
		EmployeeTaxDetails taxData = service.calculateTax(id);
		return taxData;
	}

	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		return service.persistEmployee(employee);
	}

}
