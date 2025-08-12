package practice.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountFrequencyOfWords {
    public static void main(String[] args){
        List<String> wordsList = new ArrayList<>(Arrays.asList("hello", "bye", "sky", "rock", "hello", "bye", "birds", "magic"));

        //traditional Way
        /*Map<String, Integer> wordsMap = new HashMap<>();

        wordsList.forEach(word ->{
            wordsMap.put(word, wordsMap.getOrDefault(word,0)+1);
        });

        System.out.println(wordsMap);*/

        /*List<String> wordUniqueList = wordsList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(wordUniqueList);*/

        Map<String, Long> wordsMap = wordsList.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println(wordsMap);
        //{magic=1, rock=1, sky=1, hello=2, birds=1, bye=2}
    }
}
