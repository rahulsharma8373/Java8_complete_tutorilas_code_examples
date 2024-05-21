package com.java8.functional.predicate;

import java.util.function.Predicate;

public class PredicateDemo {
	public static void main(String[] args) {

		// age>21 years

		Predicate<Integer> agecheck = age -> age > 21;
		System.out.println(agecheck.test(22));
		System.out.println(agecheck.test(18));
		if (agecheck.test(33)) {
			System.out.println("eligible");
		}
		// Employee Object : find out salary > 25000
		Employee employee = new Employee();
		employee.setId(111);
		// employee.setName("rahul");
		employee.setSalary(26000);
		Predicate<Employee> empSalaryCheck = emp -> emp.getSalary() > 25000;
		if (empSalaryCheck.test(employee)) {
			System.out.println("Above 25000");

		} else {
			System.out.println("below 25000");
		}
		// salry > 25000 and employee gender is female
		Predicate<Employee> femaleEmpl = emp -> emp.getGender().equalsIgnoreCase("female");
		employee.setGender("FEMALE");
		boolean result = empSalaryCheck.and(femaleEmpl).test(employee);
		System.out.println(result);

		// salary > 25000 0r gender is Male

		result = empSalaryCheck.or(femaleEmpl).test(employee);
		System.out.println(result);
// negate()
		result = femaleEmpl.negate().test(employee);
		System.out.println(result);

		// Employee : Have to validate other Employee
		// Employee : equal method
		Predicate<Employee> baseEmp = Predicate.isEqual(employee);
		Employee e = new Employee();
		e.setId(111);
		e.setSalary(25000);
		result = baseEmp.test(e);
		System.out.println(result);

	}
}
