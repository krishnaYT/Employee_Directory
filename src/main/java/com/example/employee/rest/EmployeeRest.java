package com.example.employee.rest;

import java.util.*;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.entity.Employee;
import com.example.employee.entity.EmployeeTax;
import com.example.employee.service.EmployeeService;

@RestController
public class EmployeeRest {
 
	@Autowired
	private EmployeeService es;

	@PostMapping("/api/employees")
    public ResponseEntity<String> storeEmployeeDetails(@RequestBody Employee employee) {
        es.storeEmployeeDetails(employee);
        return ResponseEntity.ok("Employee details stored in database successfully");
    }
	
	@GetMapping("/api/employeeTaxDetails")
	public ResponseEntity<List<EmployeeTax>> getEmployeesTaxData() {
        List<EmployeeTax> taxDetails = es.getTaxDeduction();
        return new ResponseEntity<>(taxDetails, HttpStatus.OK);
    }
}
