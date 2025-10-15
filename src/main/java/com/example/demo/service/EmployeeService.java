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
		
	}
	
	public List<Employee> getEmployees(){
		return list;
	}
	
	public void addEmployee(Employee emp) {
		cont++;
		emp.setId(cont);
		list.add(emp);
	}
	
	public void deleteEmployee(int id) {
		list.removeIf(e -> e.getId() == id);
	}

}
