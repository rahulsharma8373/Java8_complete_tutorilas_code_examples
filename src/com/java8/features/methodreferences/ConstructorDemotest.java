package com.java8.features.methodreferences;

public class ConstructorDemotest {
public static void main(String[] args) {
	GetEmployeeInstance getEmployeeInstance=Employee::new ;
	
	Employee e= getEmployeeInstance.getEmployee(100, "rahul");
	System.out.println(e.getId());
	System.out.println(e.getName ());
}
}
