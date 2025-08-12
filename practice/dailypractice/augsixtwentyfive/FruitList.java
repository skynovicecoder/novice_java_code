package practice.dailypractice.augsixtwentyfive;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FruitList {
    public static List<String> arrangeFruitsLenThanAlphabetically(List<String> stringList){
        return stringList.stream()
                //.sorted(Comparator.comparing(obj->obj.length()))
                //.sorted(Comparator.naturalOrder())
                .sorted(
                        Comparator.comparingInt(String::length)
                                .thenComparing(Comparator.naturalOrder())
                )
                .collect(Collectors.toList());
    }

    public static void main(String[] args){
        List<String> inputList = List.of("bat", "apple", "ant", "banana");
        System.out.println(arrangeFruitsLenThanAlphabetically(inputList));
    }
}
