package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
      /*  collect.forEach((dept,emps)-> {
            System.out.println("Department:"+dept +" emps:"+ emps);
        });*/

        // Sort Employees by City and name

        Map<String, List<Employee>> employeesByCity = employees.stream()
                .sorted(Comparator.comparing(Employee::getCity).thenComparing(Employee::getName)).collect(Collectors.groupingBy(Employee::getCity,LinkedHashMap::new,Collectors.toList()));

       /* employeesByCity.forEach((city,emps)->{
            System.out.println("City: "+city +" emps: "+emps);
        });*/

        //Find Employees in a City
        employees.stream().collect(Collectors.groupingBy(Employee::getCity));
              /*  .forEach((city,employes)->{
            System.out.println("City "+ city+" employees "+ employes);*/
       // });

        employees.stream().filter(emp -> "Bang".equals(emp.getCity())).toList();//.forEach(System.out::println);

        //Sort Employees by Salary:

        employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).toList();//.forEach(System.out::println);

        //Find the employee with the highest salary using Streams.

        OptionalDouble max = employees.stream().mapToDouble(Employee::getSalary).max();
       // System.out.println(max.getAsDouble());

        //Average Salary per Department:
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
               // .forEach((dept,avg)-> System.out.println("Dept "+ dept+" Avg Salary "+avg));

        //List Unique Managers:
        employees.stream().map(Employee::getManager).collect(Collectors.toSet());
                //.forEach(System.out::println);

        //Find Employees Earning More than a Certain Amount:
        employees.stream().filter( emp -> emp.getSalary()>=500000.00).map(Employee::getName).toList();
               // .forEach(System.out::println);

        //Check If Any Employee Belongs to a Specific Department:

        boolean anyMatchFromHr = employees.stream().anyMatch(emp -> "HR".equals(emp.getDepartment()));
      // System.out.println(anyMatchFromHr ? "Yes":"No");

        //Find Top 3 Highest Paid Employees
        Stream<String> top3 = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).map(Employee::getName).limit(3);
        //top3.forEach(System.out::println);

        //Count Employees per City:
        employees.stream().collect(Collectors.groupingBy(Employee::getCity,Collectors.counting()));
               // .forEach((city,count)-> System.out.println("City "+city+" Count "+count));
       //Find Department with the Highest Salary Sum
        Map<String, Double> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
       Map.Entry<String,Double> high = collect1.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
        if(high !=null){
            System.out.println("Dept "+high.getKey()+" Sum "+high.getValue());
        }
        //Partition Numbers into Even and Odd
        List<Integer> numbers = Arrays.asList(2,5,9,7,4,0);
        Map<Boolean, List<Integer>>  evenAndOdd = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        //System.out.println("Even Numbers:"+  evenAndOdd.get(true));
        //System.out.println("Odd Numbers:"+ evenAndOdd.get(false));
    }
}
