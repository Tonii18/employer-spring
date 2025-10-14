package com.example.demo.model;

public class Employee {
	
	private int id;
	private String fullName;
	private int age;
	private String email;
	private String department;
	private double salary;
	
	public Employee() {
		
	}

	public Employee(int id, String fullName, int age, String email, String department, double salary) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.email = email;
		this.department = department;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", age=" + age + ", email=" + email + ", department="
				+ department + ", salary=" + salary + "]";
	}
	
	

}
