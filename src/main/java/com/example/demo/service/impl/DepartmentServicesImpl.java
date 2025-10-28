package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentServices;

@Service("departmentService")
public class DepartmentServicesImpl implements DepartmentServices{
	
	private DepartmentRepository deptRepo;
	
	DepartmentServicesImpl(DepartmentRepository deptRepo){
		this.deptRepo = deptRepo;
	}
	
	@Autowired
	@Qualifier("departmentRepository")

	@Override
	public List<Department> listAllDepartments() {
		List<Department> list = new ArrayList<>();
		for(Department d: deptRepo.findAll()) {
			list.add(d);
		}
		
		return list;
	}

	@Override
	public Department addDept(Department dept) {
		return deptRepo.save(dept);
	}

	@Override
	public int removeDept(int id) {
		deptRepo.deleteById(id);
		return 0;
	}

	@Override
	public Department updateDept(Department dept) {
		return deptRepo.save(dept);
	}

	@Override
	public long getCount() {
		return deptRepo.count();
	}

}
