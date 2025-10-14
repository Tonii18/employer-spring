package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Department;

@Service
public class DepartmentService {
	
	private List<Department> list = new ArrayList<>();
	private int cont = 0;
	
	public DepartmentService() {
		list.add(new Department(1, "Sales","Ventas", "Juan Pérez Matos"));
		list.add(new Department(2, "Software Development","Desarrollo web, backend y frontend", "Antonio Jesús Sánchez Rosales"));
	}
	
	public List<Department> getDepartments(){
		return list;
	}
	
	public void addDepartment(Department dep) {
		list.add(dep);
	}
	
	public void deleteDepartment(Department dep) {
		list.remove(dep);
	}

}
