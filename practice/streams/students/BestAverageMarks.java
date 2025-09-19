package practice.streams.students;

import java.util.*;
import java.util.stream.Collectors;

public class BestAverageMarks {

    public static Map<String, Double> findBestAverageCase(String[][] studentsInfo) {
        Map<String, List<Integer>> studentsInfoMap = new HashMap<>();
        for (String[] data : studentsInfo) {
            String name = data[0];
            Integer marks = Integer.valueOf(data[1]);
            studentsInfoMap.putIfAbsent(name, new ArrayList<>());
            //studentsInfoMap.putIfAbsent(name, new ArrayList<>()).add(marks);
            studentsInfoMap.get(name).add(marks);
        }

        Map<String, Double> studentsAvgMap = studentsInfoMap.entrySet().stream()
                .collect(Collectors.toMap(
                        obj -> obj.getKey(),
                        obj -> obj.getValue().stream().mapToInt(num -> (Integer) num).average().orElse(0)
                ));

        Double maxAvg = studentsAvgMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(obj -> obj.getValue())
                .orElse(0.0);
        System.out.println("Max Marks : " + maxAvg);

        String name = studentsAvgMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(obj -> obj.getKey())
                .orElse("None");
        System.out.println("Max Avg. Marks candidate Name : " + name);

        //In case If you have distinct avg
        Map<String, Double> bestAvgStudent = studentsAvgMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(obj -> Map.of(obj.getKey(), obj.getValue()))
                .orElseThrow();

        Map<String, Double> bestAvgStudentSss = studentsAvgMap.entrySet().stream()
                .filter(obj -> obj.getValue().equals(maxAvg))
                .collect(Collectors.toMap(
                        obj -> obj.getKey(),
                        obj -> obj.getValue()
                ));
        System.out.println("If More than one have same result: " + bestAvgStudentSss);

        return bestAvgStudent;
    }

    public static void main(String[] args) {
        String[][] studentsInfo = {
                {"Alice", "80"},
                {"Bob", "88"},
                {"Alice", "82"},
                {"Bob", "72"},
                {"Charlie", "78"},
                {"David", "60"},
                {"Eve", "91"},
                {"Charlie", "85"},
                {"David", "70"},
                {"Eve", "89"},
                {"Alice", "90"},
                {"Bob", "95"},
                {"David", "85"},
                {"Charlie", "92"},
                {"Eve", "87"},
                {"Sonil", "89"}
        };

        System.out.println("Find the student with the average marks: " + Arrays.deepToString(studentsInfo) + " \n: is :" + findBestAverageCase(studentsInfo));
    }
}
