package com.example.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
}
