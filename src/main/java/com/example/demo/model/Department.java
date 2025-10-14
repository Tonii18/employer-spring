package com.example.demo.model;

public class Department {
	
	private int id;
	private String name;
	private String description;
	private String boss;
	
	public Department() {
		
	}

	public Department(int id, String name,String description, String boss) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.boss = boss;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBoss() {
		return boss;
	}

	public void setBoss(String boss) {
		this.boss = boss;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", description=" + description + ", boss=" + boss + "]";
	}

}
