package practice.streams.lists;

import java.util.List;
import java.util.stream.Stream;

public class MergeTwoList {
    public static List<Integer> mergeTwoList(List<Integer> list1, List<Integer> list2){
        List<Integer> output = Stream.concat(list1.stream(), list2.stream())
                .sorted((a,b)->a-b) //ascending order
                //.sorted((a,b)->b-a)  //descending order
                .toList();
        return output;
    }

    public static void main(String[] args){
        List<Integer> first = List.of(2,5,3,44,23);
        List<Integer> second = List.of(10,6,1,7,22,88);
        System.out.println(mergeTwoList(first, second));
    }
}
