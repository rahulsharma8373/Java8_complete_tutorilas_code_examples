package com.java8.features.methodreferences;

import java.util.Arrays;

import com.java8.features.methodreferences.Employee;

public class MethodRefDemoTwo {
	public static void main(String[] args) {

		// Create an instance of EmployeeValidation using method reference
		Employee e = new Employee();
		EmployeeValidation employeeValidation = e::validateEmpDetails;

		// Validating employee details
		Employee emp = new Employee();
		System.out.println(employeeValidation.isValidEmployee(emp));

		Employee emp2 = new Employee();
		emp2.setId(1);
		emp2.setName("Rahul");
		System.out.println(employeeValidation.isValidEmployee(emp2));

		// Access instance methods with class name also
		// condition
		// The method which we are referreng from any class ,That method should not
		// contains any method arguments and the same method
		// should contains same return value of abstract method which
		// defined in side Functional Interface.
		EmployeeValidation salaryValidation = Employee::validSalary;
		System.out.println(salaryValidation.isValidEmployee(emp2));
		String[] values = { "Dilip", "Java", "Spring", "Methods", "References" };
		Arrays.sort(values, (o1, o2) -> o1.compareToIgnoreCase(o2));
		for (String string : values) {
			System.out.println(string);
		}

	}
}
