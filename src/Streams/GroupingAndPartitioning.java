package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingAndPartitioning {
    public static void main(String[] args) {
        
        List<Employee> employees = Arrays.asList(
                new Employee("John", "IT", "Anupam", "Hyd", 500000.0),
                new Employee("Alice", "HR", "pooja", "Hyd", 300000.0),
                new Employee("Bob", "IT", "rajesh", "Bang", 400000.0),
                new Employee("Lilly", "Sales", "Anupam", "Hyd", 500000.0),
                new Employee("jasmine", "HR", "pooja", "Hyd", 300000.0),
                new Employee("June", "IT", "rajesh", "Bang", 400000.0),
                new Employee("Johny", "Sales", "Anupam", "Hyd", 500000.0),
                new Employee("April", "HR", "pooja", "Hyd", 300000.0),
                new Employee("Mars", "IT", "rajesh", "Bang", 400000.0),
                new Employee("Jupiter", "Sales", "Anupam", "Hyd", 500000.0),
                new Employee("Neptune", "HR", "pooja", "Hyd", 300000.0),
                new Employee("Pluto", "IT", "rajesh", "Bang", 400000.0));

        //Group Employees by Department

        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        collect.forEach((dept,emps)-> {
            System.out.println("Department:"+dept +" emps:"+ emps);
        });

        // Sort Employees by City

        Map<String, List<Employee>> employeesByCity = employees.stream()
                .sorted(Comparator.comparing(Employee::getCity).thenComparing(Employee::getName)).collect(Collectors.groupingBy(Employee::getCity,LinkedHashMap::new,Collectors.toList()));

        employeesByCity.forEach((city,emps)->{
            System.out.println("City: "+city +" emps: "+emps);
        });
        //Partition Numbers into Even and Odd
        List<Integer> numbers = Arrays.asList(2,5,9,7,4,0);
        Map<Boolean, List<Integer>>  evenAndOdd = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even Numbers:"+  evenAndOdd.get(true));
        System.out.println("Odd Numbers:"+ evenAndOdd.get(false));
    }
}
