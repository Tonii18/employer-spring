package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeServices {
	
	List<Employee> listEmployees();
	Employee addEmployee(Employee emp);
	int removeEmployee(int id);
	Employee updateEmployee(Employee emp);
	long getCount();
	Employee getEmployee(int id);
	
}
