package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeServices;

@Service("employeeService")
public class EmployeeServicesImpl implements EmployeeServices{
	
	private EmployeeRepository empRepo;
	
	EmployeeServicesImpl(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	@Autowired
	@Qualifier("employeeRepository")

	@Override
	public List<Employee> listEmployees() {
		List<Employee> list = new ArrayList<>();
		for(Employee e: empRepo.findAll()) {
			list.add(e);
		}
		
		return list;
	}

	@Override
	public Employee addEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public int removeEmployee(int id) {
		empRepo.deleteById(id);
		return 0;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public long getCount() {
		return empRepo.count();
	}

}
