package practice.streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckForFirstNonRepeatingCharacter {

    public static char checkNonRepeatingChar(String inputString){
        if (inputString == null || inputString.isBlank()) return 0;
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] charArrObj = inputString.toCharArray();
        for(char c: charArrObj){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }

        return 0;
    }

    public static char checkNRCViaStream(String inputString){
        if (inputString == null || inputString.isBlank()) return 0;

        Optional<Character> obj = inputString.chars() //IntStream
                .mapToObj(c -> (char) c) //Stream<Character>
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(ch-> ch.getValue()==1)
                .map(ch-> ch.getKey())
                .findFirst();

        return obj.orElseGet(()->'0');

        /*char[] chArray = inputString.toCharArray();
        Map<Character, Long> obj = IntStream.range(0, chArray.length)
                .mapToObj(i -> chArray[i])
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));
        Optional<Character> chObj = obj.entrySet().stream()
                .filter(map -> map.getValue() == 1)
                .map(map -> map.getKey())
                .findFirst();

        return chObj.orElse('0');*/

    }

    public static void main(String[] args){
        String input = "javajungle";
        System.out.println("First Repeated char is : "+checkNonRepeatingChar(input));

        System.out.println("In streams First Repeated char is : "+checkNRCViaStream(input));
    }
}
