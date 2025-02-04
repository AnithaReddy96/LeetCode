package Streams;

import java.util.Arrays;
import java.util.List;

public class Employee {

    private String name;
    private String department;
    private String manager;
    private String city;
    private Double salary;

    Employee(String name, String department, String manager, String city, Double salary) {
        this.name = name;
        this.department = department;
        this.manager = manager;
        this.city = city;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", manager='" + manager + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                '}';
    }
}

