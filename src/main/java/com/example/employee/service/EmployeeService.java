package com.example.employee.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.entity.Employee;
import com.example.employee.entity.EmployeeTax;

import jakarta.transaction.Transactional;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao emp;
	
	public void storeEmployeeDetails(Employee employee) {
        emp.save(employee);
    }
	
	public List<EmployeeTax> getTaxDeduction() 
	{
		List<Employee> listofemployee = emp.findAll();
		System.out.println("----"+listofemployee);
		List<EmployeeTax> taxDetailsList = new ArrayList<>();
		for(Employee e: listofemployee)
		{
			    double totalSalary = getTotalSalary(e);
	            double taxAmount = getTax(totalSalary);
	            double cessAmount = getCessAmount(totalSalary);
	            EmployeeTax taxDetails = new EmployeeTax();
	            taxDetails.setEmployeeId(e.getEmpId());
	            taxDetails.setFirstName(e.getFirstName());
	            taxDetails.setLastName(e.getLastName());
	            taxDetails.setTotalSalary(totalSalary);
	            taxDetails.setTaxAmount(taxAmount);
	            taxDetails.setCessAmount(cessAmount);

	            taxDetailsList.add(taxDetails);
	        }

	        return taxDetailsList;
		
		
	}
	public double getTotalSalary(Employee e)
	{
		double totalSal=0;
		//double tax;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	    Date firstDate;
		try {
			firstDate = sdf.parse("2023-04-01");
			Date secondDate = sdf.parse(e.getDoj());
	    	if(firstDate.compareTo(secondDate)<0)
	    	{
		    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
		    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		    double sal=((e.getSalary())/30)*diff;
		    totalSal=(e.getSalary()*12)-sal;
		    //tax=getTax(totalSal);
	    	}
	    	else
	    	{
	    		totalSal=(e.getSalary()*12);
	    		//tax=getTax(totalSal);
	    	}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
		return totalSal;
	}

	public double getTax(double amt)
	{
		long tax=0;
		if(amt<=250000)
		{
			tax=0;
		}
		else if(amt>250000 && amt<=500000)
		{
			tax=(long) (amt*0.05);
		}
		else if(amt>500000 && amt<=1000000)
		{
			tax=(long) (amt*0.1);
		}
		else if(amt>1000000)
		{
			tax=(long) (amt*0.2);
		}
		return tax;
		
	}

	public double getCessAmount(double amt)
	{
		if (amt > 2500000) {
            return (amt - 2500000) * 0.02;
        }
        return 0;
	}

}
