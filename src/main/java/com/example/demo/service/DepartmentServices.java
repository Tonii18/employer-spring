package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Department;

public interface DepartmentServices {
	
	List<Department> listAllDepartments();
	Department addDept(Department dept);
	int removeDept(int id);
	Department updateDept(Department dept);

}
