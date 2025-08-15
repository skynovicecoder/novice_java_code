package practice.dailypractice.augfifteentwentyfive;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionNumbersInEvenAndOdd {
    public static Map<Boolean, List<Integer>> partitionListInEvenAndOdd(List<Integer> inputList){
        Map<Boolean, List<Integer>> outputList = inputList.stream()
                .collect(Collectors.partitioningBy(num -> num%2==0));
        return outputList;
    }

    public static void main(String[] args){
        List<Integer> input = List.of(21,12,33,44,55,66,77,88,99,10);
        System.out.println(partitionListInEvenAndOdd(input));
    }
}
