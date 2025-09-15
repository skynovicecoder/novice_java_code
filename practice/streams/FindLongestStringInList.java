package practice.streams;

import java.util.Comparator;
import java.util.List;

public class FindLongestStringInList {

    public static String findLongestString(List<String> inputList){
       /* Map<String, Integer> map = inputList.stream()
                .collect(Collectors.toMap(
                   Function.identity(),
                   word->word.length()
                ));
        String result = map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");*/

        String result = inputList.stream()
                .max(Comparator.comparingInt(word->word.length()))
                .orElse("");

        return result;
    }

    public static void main(String[] args){
        List<String> inputList = List.of("Hello", "how" , "are", "superstar" , "Gokhu");
        System.out.println("Result is : "+findLongestString(inputList) +" : "+findLongestString(inputList).length());
    }
}
