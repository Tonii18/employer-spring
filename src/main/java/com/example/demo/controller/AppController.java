package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.service.DepartmentServices;
import com.example.demo.service.EmployeeServices;

import jakarta.validation.Valid;

@Controller
public class AppController {
	
	@Autowired
	@Qualifier("employeeService")
	private EmployeeServices empServ;
	
	@Autowired
	@Qualifier("departmentService")
	private DepartmentServices deptServ;
	
	//
	
	@GetMapping("/")
	public String init() {
		return "index";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		long totalEmployees = empServ.getCount();
		long totalDepts = deptServ.getCount();
		
		model.addAttribute("totalEmployees", totalEmployees);
		model.addAttribute("totalDepartments", totalDepts);
		
		return "home";
	}
	
	@GetMapping("/employees")
	public String employees(Model model) {
		List<Employee> list = empServ.listEmployees();
		model.addAttribute("list", list);
		
		return "employees";
	}
	
	@GetMapping("/departments")
	public String departments(Model model) {
		List<Department> list = deptServ.listAllDepartments();
		model.addAttribute("list", list);
		
		return "departments";
	}
	
	@GetMapping("/employees/new")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());		
		return "employee-form";
	}
	
	@PostMapping("/employees/add")
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee,
			BindingResult result,
			Model model) {
		
		if(result.hasErrors()) {
			return "employee-form";
		}
		
		empServ.addEmployee(employee);
		
		return "redirect:/employees";
	}
	
	@GetMapping("/departments/new")
	public String addDepartment(Model model) {
		model.addAttribute("department", new Department());
		
		return "department-form";
	}
	
	@PostMapping("/departments/add")
	public String saveDepartment(
			@Valid @ModelAttribute("department") Department department,
			BindingResult results,
			Model model
			) {
		
		if(results.hasErrors()) {
			return "department-form";
		}
		
		deptServ.addDept(department);
		
		return "redirect:/departments";
	}
	
	@GetMapping("/employees/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		empServ.removeEmployee(id);
		
		return "redirect:/employees";
	}
	
	@GetMapping("/departments/delete/{id}")
	public String deleteDepartment(@PathVariable int id) {
		deptServ.removeDept(id);
		
		return "redirect:/departments";
	}
	
	// Updating employees and departments
	
	@GetMapping("/employees/update/{id}")
	public String showUpdateForm(@PathVariable int id, Model model) {
		model.addAttribute("employee", empServ.getEmployee(id));
		
		return "employee-form";
	}
	
	@GetMapping("/departments/update/{id}")
	public String showUpdateFormDept(@PathVariable int id, Model model) {
		model.addAttribute("department", deptServ.getDepartment(id));
		
		return "department-form";
	}

}
