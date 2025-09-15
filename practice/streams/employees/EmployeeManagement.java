package practice.streams.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Employee {
    String name;
    String dept;

    public Employee(String name, String dept){
        this.name = name;
        this.dept = dept;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDept(){
        return dept;
    }

    public void setDept(String dept){
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "EmployeeManagement{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}

public class EmployeeManagement{
    public static void main(String[] args){
        List<Employee> employeeList = new ArrayList<>(List.of(
                new Employee("Sonil", "IT"),
                new Employee("Sonu", "HR"),
                new Employee("Sky", "ADMIN"),
                new Employee("Rocky", "IT"),
                new Employee("Magic", "HR"),
                new Employee("Shaktiman", "ADMIN"),
                new Employee("Chirkut", "IT"),
                new Employee("Rambo", "HR"),
                new Employee("Yadav", "ADMIN"),
                new Employee("Jumbo", "HR"),
                new Employee("Luffy", "ADMIN"),
                new Employee("Zoro", "ADMIN")
                        )
        );

        Map<String, Long> empolyeeInfo = employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept, //classifier
                        TreeMap::new, //map factory
                        Collectors.counting() //downstream
                ));

        System.out.println(empolyeeInfo);
    }
}