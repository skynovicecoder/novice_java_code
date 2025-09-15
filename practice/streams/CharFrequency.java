package practice.streams;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharFrequency {

    public static Map<Character, Long> mapCharFrequency(String input){
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        /*char[] wordsArray = input.toCharArray();
        return IntStream.range(0, wordsArray.length)
                .mapToObj(i -> wordsArray[i])
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));*/
    }

    public static void main(String[] args){
        String inputString = "banana";
        System.out.println(mapCharFrequency(inputString));
    }
}
