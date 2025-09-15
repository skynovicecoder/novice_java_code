package practice.streams;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElement {

    public static List<Integer> dupCheck(List<Integer> dupList){
        Set<Integer> dataSet = new HashSet<>();
        return dupList.stream()
                .filter(num -> !dataSet.add(num))  //adding element to set returns false if already exist
                .distinct() //to avoid duplicate in the output list
                .collect(Collectors.toList());
    }

    public static void main(String[] args){
        List<Integer> inputArray = List.of(1, 2, 3, 2, 4, 3);
        System.out.println(dupCheck(inputArray));
    }
}