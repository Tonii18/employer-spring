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
		
	}
	
	public List<Department> getDepartments(){
		return list;
	}
	
	public void addDepartment(Department dep) {
		cont++;
		dep.setId(cont);
		list.add(dep);
	}
	
	public void deleteDepartment(int id) {
		list.removeIf(d -> d.getId() == id);
	}

}
