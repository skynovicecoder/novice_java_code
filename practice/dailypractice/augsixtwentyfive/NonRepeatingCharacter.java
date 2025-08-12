package practice.dailypractice.augsixtwentyfive;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NonRepeatingCharacter {

    public static char nonRepeatingUsingStreams(String inputString) {
        if(inputString==null || inputString.isBlank()) return '0';

        //char[] wordArray = inputString.toCharArray();
        //Stream<Character> charStream = IntStream.range(0, wordArray.length)
        //        .mapToObj(i -> wordArray[i]);
        //Above two lines can be replaced with bellow line.
        Stream<Character> charStream = inputString.chars()
                .mapToObj(c -> (char) c);

        //charStream.forEach(System.out::println);
        Map<Character, Long> wordsMap =  charStream.collect(
                Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                )
        );

        Optional<Character> result = wordsMap.entrySet().stream()
                .filter(entry -> entry.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println("First Non Repeating Character: "+result.orElse('0'));

        return result.orElse('0');
    }

    public static char nonRepeatingUsingColections(String inputString) {

        if (inputString == null || inputString.isBlank()) return 0;

        //LinkedHash Map is the key here otherwise if hashmap is used,
        // then for maintaining order we need to use one more data structure
        Map<Character, Integer> charMap = new LinkedHashMap<>();

        char[] charArray = inputString.toCharArray();
        for (char c : charArray) {
            charMap.put(c, (charMap.getOrDefault(c, 0) + 1));
        }

        for (Map.Entry<Character, Integer> map : charMap.entrySet()) {
            if (map.getValue() == 1) {
                return map.getKey();
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String[] inputList = {"javajungle", "", null, "  ", "racecars"};

        for (String input : inputList) {
            //System.out.println(nonRepeatingUsingColections(input));
            System.out.println(nonRepeatingUsingStreams(input));
        }
    }
}
