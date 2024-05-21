package com.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

	public static void main(String[] args) {
		List<Employee> employees = employeesList();
		// Stream method / operations
// Required : Get All employee name as list

		Stream<Employee> empStream = employees.stream();
		// stream pipeline
		List<String> allEmpNmae = empStream.map(emp -> emp.getName()).toList();
		System.out.println(allEmpNmae);

		// filter()
		// Note--->>> we can't use ek se jyda baar stream converted reference
		// employees names age>25
		Stream<Employee> empStreamm = employees.stream();
		List<String> ageiseName = empStreamm.filter(emp -> emp.getAge() > 25). // Intermediate operations
				map(emp -> emp.getName()).toList();// Terminal operation
// terminal method always give the result
		System.out.println(ageiseName);

		// print all city names of employees
		employees.stream().map(emp -> // stream objects
		emp.getCity()) // Intermediate operations
				.distinct(). // Intermediate operations
				forEach(System.out::println);

		// Note :-->> on stream objects we can call only one terminal method

		// Get Count all employees whose salary>20000
		long countemp = employees.stream().filter(emp -> emp.getSalary() > 20000).count();
		System.out.println(countemp);

		// Get first 3 employee objects as a list
		List<Employee> firstThreeEmp = employees.stream().limit(3).toList();
		System.out.println(firstThreeEmp);

		// skip first 3 employee and then collect data
		List<Employee> countempp = employees.stream().skip(3).toList();
		System.out.println(countempp);

		// anyMatch()
		// Verify any emp<28
		boolean isUnderAge = employees.stream().anyMatch(emp -> emp.getAge() < 28);
		System.out.println(isUnderAge);
// allMatch()
		// check employee joined 2010 0r not
		boolean emp2010 = employees.stream().allMatch(emp -> emp.getYearOfJoining() > 2010);
		System.out.println(emp2010);
// any one matching : false
		// no one matching : true
		// noneMatch()
		// every employee salary<10000
		boolean salary10000 = employees.stream().noneMatch(emp -> emp.getSalary() < 10000);
		System.out.println(salary10000);
		// findAny() ->> it take any values from list
		// get one value from out of all values
		Employee emp = employees.stream().findAny().get();
		System.out.println(emp);
// findFirst()
		// it will always return first element of the straem
		Employee emp1 = employees.stream().findFirst().get();
		System.out.println(emp1);

		// sorted()
		// Get employee id in sorted order
		List<Integer> sorted = employees.stream() // Stream of Employee Objects
				.map(empp -> empp.getId()) // stream of employee id values
				.sorted().toList();
		System.out.println(sorted);
		// sorted : Comparator arg
		// Define Sorting based on employee Id's
		// sort Employees Objects
		List<Employee> sorteEmpObjects = employees.stream().sorted((e1, e2) -> {
			return e1.getId() - e2.getId();
		}).toList();
		System.out.println(sorteEmpObjects);

		// minimum salary employee details
		Employee minSalary = employees.stream().min((e1, e2) -> (int) (e1.getSalary() - e2.getSalary())).get();
		System.out.println(minSalary);

// max()

		Employee maxSalary = employees.stream().max((e1, e2) -> (int) (e1.getSalary() - e2.getSalary())).get();
		System.out.println(maxSalary);
// average()
// find average salary of employee
// DoubleStream : Stream contains only double value

		double avgValue = employees.stream().mapToDouble(empp -> empp.getSalary()).average().getAsDouble();
		System.out.println(avgValue);

		// mapToInt -->> Integerstream
		// avg age of emp.
		double avgValuee = employees.stream().mapToInt(empp -> empp.getAge()).average().getAsDouble();
		System.out.println(avgValuee);
		// mapToLong-->> LongStream
		double avgValueee = employees.stream().mapToLong(empp -> empp.getAge()).average().getAsDouble();
		System.out.println(avgValueee);

		// peek()
		List<Employee> empDetails = employees.stream().peek(System.out::println)
				.filter(empp -> empp.getYearOfJoining() > 2015).toList();
		System.out.println(empDetails);

		System.out.println("*****************parallelStream******8");
		List<Employee> empDetailss = employees.parallelStream().peek(System.out::println)
				.filter(empp -> empp.getYearOfJoining() > 2015).toList();
		System.out.println(empDetailss);

		// collectors()
		// collectors : jDK8, as part of Stream API operations

		// Collect employees whose age is greater than 25
		List<String> employName = employees.stream().filter(empp -> empp.getAge() > 25).map(Employee::getName)
				.collect(Collectors.toList());

		System.out.println(employName);

		// Get unique department name
		Set<String> uniqueDep = employees.stream().map(Employee::getDepartment).collect(Collectors.toSet());
		System.out.println(uniqueDep);

		// collect employee ids and their salaries as mapa
		Map<Integer, Double> empIdsAndSalaries = employees.stream()
				.collect(Collectors.toMap(Employee::getId, Employee::getSalary));
		System.out.println(empIdsAndSalaries);

		// groupingBy()
		// get avg salary of each department
		Map<String, Double> avgSalryDep = employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(avgSalryDep);
		// count()
		// Get count of employee gender wise
		Map<String, Long> employeeGender = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(employeeGender);

		// summing...
		// summarising...
		System.out.println(employees.stream().collect(Collectors.summingDouble(Employee::getSalary)));
		System.out.println(employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary)));
// maxBy()
		// finding max age of employee
		Employee maxEmp = employees.stream().collect(Collectors.maxBy((e1, e2) -> e1.getAge() - e2.getAge())).get();
		System.out.println(maxEmp);
		// joining()
		// All Departments names with delimeter :::
		String allDep = employees.stream().map(Employee::getDepartment).collect(Collectors.joining(":::"));
		System.out.println(allDep);
		System.out.println("Filtering Employees by Department:");
		// Filtering Employees by Department:
		List<Employee> salesEmployees = employees.stream().filter(empp -> "Sales".equals(empp.getDepartment()))
				.collect(Collectors.toList());

		salesEmployees.forEach(System.out::println);
		// Mapping Employees to Their Names:
		List<String> employeeNames = employees.stream().map(Employee::getName).collect(Collectors.toList());

		employeeNames.forEach(System.out::println);
		// counting Employee to specific city
		long countPuneEmployees = employees.stream().filter(empp -> "Hyderabad".equals(empp.getCity())).count();

		System.out.println("Number of employees in Pune: " + countPuneEmployees);
		// Sorting Employees by Salary:
		List<Employee> sortedBySalary = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary))
				.collect(Collectors.toList());

		sortedBySalary.forEach(System.out::println);
		// Finding the Employee with the Highest Salary:
		Optional<Employee> highestSalaryEmployee = employees.stream()
				.max(Comparator.comparingDouble(Employee::getSalary));

		highestSalaryEmployee.ifPresent(System.out::println);

		// Grouping Employees by Department:
		Map<String, List<Employee>> employeesByDepartment = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		employeesByDepartment.forEach((department, empp) -> {
			System.out.println(department);
			empp.forEach(System.out::println);
		});
		// Partitioning Employees by Salary:
		Map<Boolean, List<Employee>> partitionedBySalary = employees.stream()
				.collect(Collectors.partitioningBy(empp -> empp.getSalary() > 20000));

		System.out.println("Employees with salary above 20000:");
		partitionedBySalary.get(true).forEach(System.out::println);

		System.out.println("Employees with salary 20000 or below:");
		partitionedBySalary.get(false).forEach(System.out::println);

		// Getting Average Salary by Gender:

		Map<String, Double> averageSalaryByGender = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

		averageSalaryByGender.forEach((gender, avgSalary) -> {
			System.out.println("Average salary for " + gender + ": " + avgSalary);
		});
//Summarizing Statistics of Employee Salaries:
		DoubleSummaryStatistics salaryStatistics = employees.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));

		System.out.println("Salary Statistics: " + salaryStatistics);

		// Joining Employee Names:
		String joinedEmployeeNames = employees.stream().map(Employee::getName).collect(Collectors.joining(", "));

		System.out.println("Joined Employee Names: " + joinedEmployeeNames);

		// Filtering and Mapping Together:

		List<String> namesAfter2014 = employees.stream().filter(empp -> empp.getYearOfJoining() > 2014)
				.map(Employee::getName).collect(Collectors.toList());

		namesAfter2014.forEach(System.out::println);

		// Finding Any Employee in a Department:
		Optional<Employee> anyDevelopmentEmployee = employees.stream()
				.filter(empp -> "Development".equals(empp.getDepartment())).findAny();

		anyDevelopmentEmployee.ifPresent(System.out::println);
// Reducing to Compute Total Salary:
//Reducing to Compute Total Salary:
		double totalSalary = employees.stream().map(Employee::getSalary).reduce(0.0, Double::sum);

		System.out.println("Total Salary: " + totalSalary);
// Reducing to Find the Oldest Employee:
		Optional<Employee> oldestEmployee = employees.stream()
				.reduce((e1, emp2) -> e1.getAge() > emp2.getAge() ? e1 : emp2);

		oldestEmployee.ifPresent(System.out::println);

		// Collecting Data into a Custom Container:
		TreeSet<Employee> employeesById = employees.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingInt(Employee::getId))));

		employeesById.forEach(System.out::println);

		// Partitioning by Multiple Criteria:
		// Partition employees by gender and then by whether they earn more than 20,000.
		Map<String, Map<Boolean, List<Employee>>> partitionedByGenderAndSalary = employees.stream().collect(Collectors
				.groupingBy(Employee::getGender, Collectors.partitioningBy(empp -> empp.getSalary() > 20000)));

		partitionedByGenderAndSalary.forEach((gender, partition) -> {
			System.out.println("Gender: " + gender);
			partition.forEach((highSalary, empp) -> {
				System.out.println("Salary > 20000: " + highSalary);
				empp.forEach(System.out::println);
			});
		});

// Mapping to Extract Custom Data:
		// Extract a map of employee names and their respective cities.

		Map<String, String> employeeNameCityMap = employees.stream()
				.collect(Collectors.toMap(Employee::getName, Employee::getCity));

		employeeNameCityMap.forEach((name, city) -> {
			System.out.println(name + " lives in " + city);
		});
		// Counting Employees in Each Department:
		Map<String, Long> employeeCountByDepartment = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		employeeCountByDepartment.forEach((department, count) -> {
			System.out.println(department + ": " + count + " employees");
		});
// Finding Employee with the Minimum Salary:
		Optional<Employee> minSalaryEmployee = employees.stream().min(Comparator.comparingDouble(Employee::getSalary));

		minSalaryEmployee.ifPresent(System.out::println);
// Chaining Multiple Operations:
		// Find the names of all employees in "Pune" who earn more than 20,000, sorted
		// by name.

		List<String> highEarningPuneEmployees = employees.stream()
				.filter(empp -> "Pune".equals(empp.getCity()) && empp.getSalary() > 20000).map(Employee::getName)
				.sorted().collect(Collectors.toList());

		highEarningPuneEmployees.forEach(System.out::println);
		// Parallel Streams:
		// Process employees in parallel to find the average salary.
		double averageSalary = employees.parallelStream().mapToDouble(Employee::getSalary).average().orElse(0.0);

		System.out.println("Average Salary: " + averageSalary);

	}

	public static List<Employee> employeesList() {

		List<Employee> employeeList = new ArrayList<>();

		employeeList.add(new Employee(6, "Six", 43, "Male", "Security", 2016, 9500.0, "Pune"));
		employeeList.add(new Employee(7, "Seven", 35, "Male", "Finance", 2010, 27000.0, "Pune"));
		employeeList.add(new Employee(3, "Three", 29, "Male", "Infrastructure", 2012, 18000.0, "Hyderabad"));
		employeeList.add(new Employee(8, "Eight", 31, "Male", "Development", 2015, 34500.0, "Pune"));
		employeeList.add(new Employee(9, "Nine", 24, "Female", "Sales", 2016, 11500.0, "Hyderabad"));
		employeeList.add(new Employee(10, "Ten", 25, "Female", "Sales", 2009, 22500.0, "Pune"));
		employeeList.add(new Employee(2, "Two", 25, "Male", "Sales", 2015, 13500.0, "Hyderabad"));
		employeeList.add(new Employee(4, "Four", 28, "Female", "Development", 2014, 32500.0, "Pune"));
		employeeList.add(new Employee(5, "Five", 27, "Female", "HR", 2013, 22700.0, "Pune"));
		employeeList.add(new Employee(1, "One", 32, "Female", "HR", 2011, 25000.0, "Hyderabad"));

		return employeeList;
	}

}
