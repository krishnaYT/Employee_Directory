package com.example.employee.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "emp_id")
	private String empId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "doj")
	private String doj;
	
	@Column(name = "ph")
	private List<String> phNo;
	
	@Column(name = "salary")
	private double salary;

public Employee()
{
	
}

public Employee(int id, String emp_id, String firstName, String lastName, String email, String doj,
		List<String> ph, double salary) {
	super();
	this.id = id;
	this.empId = emp_id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.doj = doj;
	this.phNo = ph;
	this.salary = salary;
}

public int getId() {
	return id;
}

public String getEmpId() {
	return empId;
}

public String getFirstName() {
	return firstName;
}

public String getLastName() {
	return lastName;
}

public String getEmail() {
	return email;
}

public String getDoj() {
	return doj;
}

public List<String> getPh() {
	return phNo;
}

public double getSalary() {
	return salary;
}

public void setId(int id) {
	this.id = id;
}

public void setEmpId(String empId) {
	this.empId = empId;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public void setEmail(String email) {
	this.email = email;
}

public void setDoj(String doj) {
	this.doj = doj;
}

public void setPh(List<String> ph) {
	this.phNo = ph;
}

public void setSalary(double salary) {
	this.salary = salary;
}

@Override
public String toString() {
	return "Employee [id=" + id + ", empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", email=" + email + ", doj=" + doj + ", phoneNumbers=" + phNo + ", salary=" + salary + "]";
}

}
