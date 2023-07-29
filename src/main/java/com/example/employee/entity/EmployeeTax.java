package com.example.employee.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class EmployeeTax {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
		private String employeeId;
	    private String firstName;
	    private String lastName;
	    private double totalSalary;
	    private double taxAmount;
	    private double cessAmount;
	    public EmployeeTax()
	    {
	    	
	    }
		public EmployeeTax(String employeeId, String firstName, String lastName, double totalSalary, double taxAmount,
				double cessAmount) {
			super();
			this.employeeId = employeeId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.totalSalary = totalSalary;
			this.taxAmount = taxAmount;
			this.cessAmount = cessAmount;
		}
		
		public int getId() {
			return id;
		}
		public String getEmployeeId() {
			return employeeId;
		}
		public String getFirstName() {
			return firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public double getTotalSalary() {
			return totalSalary;
		}
		public double getTaxAmount() {
			return taxAmount;
		}
		public double getCessAmount() {
			return cessAmount;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public void setTotalSalary(double totalSalary) {
			this.totalSalary = totalSalary;
		}
		public void setTaxAmount(double taxAmount) {
			this.taxAmount = taxAmount;
		}
		public void setCessAmount(double cessAmount) {
			this.cessAmount = cessAmount;
		}
		@Override
		public String toString() {
			return "EmployeeTax [empId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", totalSalary=" + totalSalary + ", taxAmount=" + taxAmount + ", cessAmount=" + cessAmount + "]";
		}
		
		

}
