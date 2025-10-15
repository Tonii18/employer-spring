package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
public class AppController {
	
	private EmployeeService empService;
	private DepartmentService depService;
	
	public AppController(EmployeeService empService, DepartmentService depService) {
		this.empService = empService;
		this.depService = depService;
	}
	
	@GetMapping("/")
	public String init() {
		return "index";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/employees")
	public String employees(Model model) {
		List<Employee> list = empService.getEmployees();
		model.addAttribute("list", list);
		
		return "employees";
	}
	
	@GetMapping("/departments")
	public String departments(Model model) {
		List<Department> list = depService.getDepartments();
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
		
		empService.addEmployee(employee);
		
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
		
		depService.addDepartment(department);
		
		return "redirect:/departments";
	}
	
	@GetMapping("/employees/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		empService.deleteEmployee(id);
		
		return "redirect:/employees";
	}
	
	@GetMapping("/departments/delete/{id}")
	public String deleteDepartment(@PathVariable int id) {
		depService.deleteDepartment(id);
		
		return "redirect:/departments";
	}

}
