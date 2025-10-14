package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
public class EmployeeService {
	
	private List<Employee> list = new ArrayList<>();
	private int cont = 0;
	
	public EmployeeService() {
		list.add(new Employee(1, "Antonio Jesús Sánchez Rosales", 21, "ajsanrosal@gmail.com", "Software development", 5500D));
		list.add(new Employee(2, "Ana Gutiérrez Pérez", 20, "anagp20@gmail.com", "Sales", 2350D));
	}
	
	public List<Employee> getEmployees(){
		return list;
	}
	
	public void addEmployee(Employee emp) {
		list.add(emp);
	}
	
	public void deleteEmployee(Employee emp) {
		list.remove(emp);
	}

}
