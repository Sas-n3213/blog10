package com.blog.util;

import com.blog.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainUtil {
    public static void main(String[] args) {
        List<Employee> data = Arrays.asList(new Employee("mike", 5000),
                new Employee("stallin", 25400),
                new Employee("mike", 5000));
        Map<Double, List<Employee>> groups = data.stream().collect(Collectors.groupingBy(Employee::getSalary));
        System.out.println(groups);
        for (Map.Entry<Double, List<Employee>>entry:groups.entrySet()) {
            double salary= entry.getKey();
            System.out.println("Employee with salary "+salary+":");
            List<Employee> employeeList=entry.getValue();
            for (Employee employee:employeeList) {
                System.out.println("\t"+employee.getName());
            }

        }
    }

}