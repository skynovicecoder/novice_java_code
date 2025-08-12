package practice.streams;

import java.util.*;
import java.util.stream.Collectors;

class EmployeeInfo {
    String name;
    int age;
    String department;
    double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public EmployeeInfo(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
public class EmployeePlayAround {

    public static void main(String[] args){
    List<EmployeeInfo> employeeInfoList = new ArrayList<>(List.of(
            new EmployeeInfo("Hyderabad", 35, "Security", 10000 ),
            new EmployeeInfo("Sky", 35, "AIT", 500000 ),
            new EmployeeInfo("Rocky", 36, "IT", 40000 ),
            new EmployeeInfo("Yadav", 34, "HR", 30000 ),
            new EmployeeInfo("Yaduwanshi", 33, "Finance", 40000 ),
            new EmployeeInfo("Pune", 35, "HR", 90000 ),
            new EmployeeInfo("Bengaluru", 35, "Security", 1000 )
    ));

    /*Map<String, Double> avgSalaryByDept = employeeInfoList.stream()
            .collect(Collectors.groupingBy(
                    EmployeeInfo::getDepartment,
                    Collectors.averagingDouble(EmployeeInfo::getSalary)
            ));
    System.out.println("Employee Average Salary by department wise: "+avgSalaryByDept);*/

        /*Map<String, Double> avgSalaryByDeptOrderByDepartmentName = employeeInfoList.stream()
                .collect(Collectors.groupingBy(
                        EmployeeInfo::getDepartment,
                        TreeMap::new,
                        Collectors.averagingDouble(EmployeeInfo::getSalary)
                ));
        System.out.println("Employee Average Salary by department wise: "+avgSalaryByDeptOrderByDepartmentName);*/

        Map<String, Double> avgSalaryByDept = employeeInfoList.stream()
                .collect(Collectors.groupingBy(
                     EmployeeInfo::getDepartment,
                     Collectors.averagingDouble(EmployeeInfo::getSalary)
                ));
        Map<String, Double> salaryInfoByDeptSortedInDesc = avgSalaryByDept.entrySet().stream()
                .sorted(Map.Entry.<String, Double> comparingByValue().reversed())
                //.sorted(Map.Entry.<String, Double> comparingByKey().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, //key mapper
                        Map.Entry::getValue, //value mapper
                        (e1, e2) -> e1, //merge function
                        LinkedHashMap::new //map supplier
                ));
        System.out.println("Sorted by Salary avg salary of dept in descending order : "+salaryInfoByDeptSortedInDesc);

    }
}
