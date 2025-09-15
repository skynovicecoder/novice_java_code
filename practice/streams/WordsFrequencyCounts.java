package practice.streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordsFrequencyCounts {
    public static Map<String, Long> wordsFrequencyCount(String input){
        String[] wordsArray = input.split("\\s+");
        Map<String, Long> outputMap = Arrays.stream(wordsArray)
                .map(str-> str.toLowerCase())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        //TreeMap::new, // sorted by key
                        Collectors.counting()
                )).entrySet().stream()
                .sorted(Map.Entry.<String, Long> comparingByValue().reversed())
                //.limit(5)
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1,e2)->e1,
                                LinkedHashMap::new
                        )
                );

        return outputMap;
    }
    public static void main(String[] args){
        String input = "How are you doing . Hope everything is good . Take care of you . You are a rockstar";
        System.out.println(wordsFrequencyCount(input));
    }
}
