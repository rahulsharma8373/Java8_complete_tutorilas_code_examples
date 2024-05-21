package com.java8.features.methodreferences;

@FunctionalInterface
public interface EmployeeValidation {
	// Taking in Emp Details and checking id,name : true or else false
	boolean isValidEmployee(Employee employee);
}
