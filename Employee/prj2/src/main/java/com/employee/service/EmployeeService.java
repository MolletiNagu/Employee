package com.employee.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.model.EmployeeTaxDetails;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	public Page<Employee> getAll(Pageable page) {
		Page<Employee> list = repo.findAll(page);
		return list;
	}

	public Employee persistEmployee(Employee employee) {
		return repo.save(employee);
	}

	public EmployeeTaxDetails calculateTax(int id) {
		Employee employee = repo.findById(id).get();
		int salary = employee.getSalary();
		LocalDate joinDate = LocalDate.parse(employee.getDoj());
		LocalDate financialYearStart = LocalDate.of(joinDate.getYear(), Month.APRIL, 1);
		LocalDate financialYearEnd = LocalDate.of(joinDate.getYear() + 1, Month.MARCH, 31);
		// Calculate the number of months in the financial year
		long monthsInFinancialYear = ChronoUnit.MONTHS.between(financialYearStart, financialYearEnd);
		// Calculate salary for the financial year
		double totalSalary = (salary / 30) * monthsInFinancialYear;
		// Calculate tax and cess
		double tax = 0;
		double cess = 0;
		if (totalSalary <= 250000) {
		} else if (totalSalary <= 500000) {
			tax = (totalSalary - 250000) * 0.05;
		} else if (totalSalary <= 1000000) {
			tax = 250000 * 0.05 + (totalSalary - 500000) * 0.10;
		} else {
			// 20% tax for salary > 1000000
			tax = 250000 * 0.05 + 500000 * 0.10 + (totalSalary - 1000000) * 0.20;
		}
		// Collect 2% cess for the amount more than 2500000
		if (totalSalary > 2500000) {
			cess = (totalSalary - 2500000) * 0.02;
		}
		EmployeeTaxDetails empTaxDetails= new EmployeeTaxDetails();
		empTaxDetails.setEmployeeCode(employee.getEmployeeId());
		empTaxDetails.setFirstName(employee.getFirstName());
		empTaxDetails.setLastName(employee.getLastName());
		empTaxDetails.setYearlySalary(totalSalary);
		empTaxDetails.setTaxAmount(tax);
		empTaxDetails.setCessAmount(cess);
		return empTaxDetails;

	}

	}

