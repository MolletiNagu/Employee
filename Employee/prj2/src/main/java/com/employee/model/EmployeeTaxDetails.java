package com.employee.model;


public class EmployeeTaxDetails {

	private int employeeCode;
	private String firstName;
	private String lastName;
	private double yearlySalary;
	private double taxAmount;
	private double cessAmount;
	public int getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(double totalSalary) {
		this.yearlySalary = totalSalary;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double tax) {
		this.taxAmount = tax;
	}
	public double getCessAmount() {
		return cessAmount;
	}
	public void setCessAmount(double cess) {
		this.cessAmount = cess;
	}
	
	
	
}
