package practice.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicates {
    public static int[] findDuplicates(int[] inputArray){
        Set<Integer> seen = new HashSet<>();

        int[] output= Arrays.stream(inputArray)
                .filter(num-> !seen.add(num))
                .distinct()
                .toArray();
        return output;
    }

    public static List<Integer> findDepInList(List<Integer> intList){
        Set<Integer> seen = new HashSet<>();
        List<Integer> outputList = intList.stream()
                .filter(num-> !seen.add(num))
                .distinct()
                .collect(Collectors.toList());
        return outputList;
    }

    public static void main(String[] args){
        int[] inputArray = {1, 2, 3, 4, 5, 1, 2, 6, 2};
        System.out.println(Arrays.toString(findDuplicates(inputArray)));
        List<Integer> inputList = Arrays.stream(inputArray)
                        .boxed()
                        .collect(Collectors.toList());
        System.out.println("List Of Duplicates :"+findDepInList(inputList));
    }
}
