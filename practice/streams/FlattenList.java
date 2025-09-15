package practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlattenList {

    public static List<Integer> flatenList(List<List<Integer>> nestedList) {
        return nestedList.stream()
                .flatMap(data -> data.stream())
                .sorted()
                //.distinct()
                //.skip(2)
                //.limit(5)
                //.toList().reversed();
                .collect(Collectors.toList());
        //.reversed();
    }

    public static void main(String[] args) {
        List<List<Integer>> nestedIntList = List.of(
                Arrays.asList(1, 2, 3),
                Arrays.asList(7, 8, 9),
                Arrays.asList(4, 5, 6),
                Arrays.asList(2, 3, 4),
                Arrays.asList(12, 13, 15)
        );

        System.out.println(flatenList(nestedIntList));
    }
}
