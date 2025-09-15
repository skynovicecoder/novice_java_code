package practice.streams.employee;

import java.util.*;
import java.util.stream.Collectors;

record Employee(String Name, int salary, String dept){}

public class EmployeeManagement {

    public static Map<String, Double> groupByDeptAndAvgSalary(List<Employee> empList){
        Map<String, Double> empData = empList.stream()
                .collect(Collectors.groupingBy(
                  Employee::dept,
                  TreeMap::new,
                  Collectors.averagingInt(Employee::salary)
                ));
        Map<String, Double> sortedInDecendingOrder = empData.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                //.sorted(Map.Entry.<String, Double>comparingByKey().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1,e2)->e1,  //Merge function , required to take decision when two keys are same, here we are taking first and discarding other
                        LinkedHashMap::new //For maintaining the insertion order
                ));
        return sortedInDecendingOrder;
    }

    public static void main(String[] args){
        List<Employee> empList = List.of(
                new Employee("Zoro", 12323, "IT"),
                new Employee("Sky", 7234452, "Security"),
                new Employee("Rocky", 7665443, "HR"),
                new Employee("Gokhu", 6665445, "Security"),
                new Employee("Gohan", 23455, "Security"),
                new Employee("Luffy", 8767656, "HR"),
                new Employee("Nami", 2345333, "IT")
        );
        System.out.println("Group By Dept and Avg Salary : "+groupByDeptAndAvgSalary(empList));
    }
}
