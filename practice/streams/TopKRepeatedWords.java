package practice.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKRepeatedWords {
    public static List<String> findKTopWords(List<String> inputList, int k){
        return inputList.stream()
                .collect(Collectors.groupingBy(
                   Function.identity(),
                        //TreeMap::new,
                        Collectors.counting()
                )).entrySet().stream()
                //.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .sorted((a,b) -> {
                    int freq= b.getValue().compareTo(a.getValue());
                    if(freq==0){
                        return b.getKey().compareTo(a.getKey());
                    }
                    return freq;
                })
                .limit(k)
                .map(Map.Entry::getKey)
                //.sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public static void main(String[] args){
        List<String> inputWordList = List.of("i", "love", "google", "i", "love", "coding", "google");
        int k=2;
        System.out.println(findKTopWords(inputWordList, k));
    }
}
