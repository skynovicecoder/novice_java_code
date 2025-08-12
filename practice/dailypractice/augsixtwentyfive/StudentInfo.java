package practice.dailypractice.augsixtwentyfive;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Student(int rollNum, String name, int score) {
}

public class StudentInfo {
    public static Map<Boolean, List<Student>> partitionList(List<Student> studentList) {
        return studentList.stream()
                .collect(Collectors.partitioningBy(obj -> obj.score() >= 40));
    }

    public static Map<String, List<Student>> multiPartitionList(List<Student> studentList) {
        return studentList.stream()
                .collect(Collectors.groupingBy(
                        obj -> {
                            if (obj.score() >= 75) return "Distinction";
                            else if (obj.score() >= 40) return "Pass";
                            else return "Retrying";
                        }
                ));
    }

    public static void main(String[] args) {
        List<Student> studentList = List.of(
                new Student(27, "Sonil", 81),
                new Student(21, "Sky", 69),
                new Student(13, "Sonu", 33),
                new Student(18, "Rocky", 38),
                new Student(33, "Chirkut", 98)
        );
        Map<Boolean, List<Student>> result = partitionList(studentList);
        System.out.println("Passed Student : " + result.get(true));
        System.out.println("Retrying Students : " + result.get(false));
        System.out.println("Student : " + result);
        System.out.println("Detailed distribution : " + multiPartitionList(studentList));
    }
}
