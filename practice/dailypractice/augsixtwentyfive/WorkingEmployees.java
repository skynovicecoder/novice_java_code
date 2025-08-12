package practice.dailypractice.augsixtwentyfive;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

record CompanyEmployee(String name, int salary, String dept, String location) {
}

public class WorkingEmployees {
    public static Optional<CompanyEmployee> secondHighestSalary(List<CompanyEmployee> empList) {
        return empList.stream()
                .sorted(Comparator.comparingInt(CompanyEmployee::salary).reversed())
                .map(CompanyEmployee::salary)
                .distinct()
                .skip(1)
                .limit(1)
                .findFirst()
                .flatMap(secondHigSalary -> empList.stream()
                        .filter(emp -> emp.salary() == secondHigSalary)
                        .findFirst()
                );
    }

    public static Optional<String> secondHighestSalaryEmp(List<CompanyEmployee> empList) {
        return empList.stream()
                .sorted(Comparator.comparingInt(CompanyEmployee::salary).reversed())
                .map(CompanyEmployee::salary)
                .distinct()
                .skip(1)
                .limit(1)
                .findFirst()
                .flatMap(secondHigSal -> empList.stream()
                        .filter(emp -> emp.salary() == secondHigSal)
                        //.map(CompanyEmployee::name)
                        .map(cmpEmp -> cmpEmp.name() + " :: " + cmpEmp.salary())
                        .findFirst());
    }

    public static void empSortedBySalary(List<CompanyEmployee> empList) {
        empList.stream()
                .sorted(Comparator.comparingInt(CompanyEmployee::salary).reversed())
                //.skip(1)
                //.limit(2)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<CompanyEmployee> employeeList = List.of(
                new CompanyEmployee("Sonil", 7500000, "IT", "Hyderabad"),
                new CompanyEmployee("Sky", 6554727, "HR", "Pune"),
                new CompanyEmployee("Sonu", 4433322, "Finance", "Varanasi"),
                new CompanyEmployee("Rocky", 928282, "Security", "Raipur"),
                new CompanyEmployee("Chirkut", 2382838, "Admin", "Delhi"),
                new CompanyEmployee("Scrapper", 5154727, "HR", "Pune")
        );

        System.out.println(secondHighestSalary(employeeList).isPresent() ? secondHighestSalary(employeeList).get() : "None");
        System.out.println(secondHighestSalaryEmp(employeeList).isPresent() ? secondHighestSalaryEmp(employeeList).get() : "None");

        empSortedBySalary(employeeList);
    }
}
