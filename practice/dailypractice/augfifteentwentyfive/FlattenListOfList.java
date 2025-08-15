package practice.dailypractice.augfifteentwentyfive;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlattenListOfList {
    public static List<Integer> flattenList(List<List<Integer>> listOfList){
        List<Integer> outputList = listOfList.stream()
                .flatMap(list->list.stream())
                .sorted((a,b)->b-a)
                .collect(Collectors.toList());
                //.reversed();
        return outputList;
    }

    public static void main(String[] args){
        List<List<Integer>> inputList = List.of(
                Arrays.asList(1,2),
                Arrays.asList(5,6),
                Arrays.asList(8,9),
                Arrays.asList(3,4),
                Arrays.asList(7,10)

        );

        System.out.println(flattenList(inputList));
    }
}
