package com.java8.features.methodreferences;

public class Employee {
	private int id;
	private String name;
	private String gender;
	private double salary;

	Employee() {
		System.out.println("no data");
	}

	Employee(int eid, String name) {
		System.out.println("with data");
		this.id = eid;
		this.name = name;
	}

	// static method
	boolean validateEmpDetails(Employee employee) {
		// id and name should be presented
		if (employee.getId() != 0 && employee.getName() != null)
			return true;
		return false;

	}

	// No method arguments
	boolean validSalary() {
		return this.getSalary() > 0 ? true : false;
	}

	// Setter method for id
	public void setId(int id) {
		this.id = id;
	}

	// Getter method for id
	public int getId() {
		return id;
	}

	// Setter method for name
	public void setName(String name) {
		this.name = name;
	}

	// Getter method for name
	public String getName() {
		return name;
	}

	// Setter method for gender
	public void setGender(String gender) {
		this.gender = gender;
	}

	// Getter method for gender
	public String getGender() {
		return gender;
	}

	// Setter method for salary
	public void setSalary(double salary) {
		this.salary = salary;
	}

	// Getter method for salary
	public double getSalary() {
		return salary;
	}
}
