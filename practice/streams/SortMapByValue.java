package practice.streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValue {
    public static Map<String, Integer> sortMapByValue(Map<String, Integer> inputMap) {

        Map<String, Integer> outputMap = inputMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) //sorting by value
                //.sorted(Map.Entry.<String, Integer>comparingByKey().reversed()) //sorting by key
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        return outputMap;
    }
    public static void main(String[] args){
        /*Map<String, Integer> inputMap = Map.of(
                "Gokhu", 99999,
                "Gohan", 34555,
                "Vegita", 77777,
                "Picolo", 53636
        );  //Map.of() can have upto 10 entries only*/

        Map<String, Integer> inputMap = Map.ofEntries(
                Map.entry("Gokhu", 99999),
                Map.entry("Gohan", 34555),
                Map.entry("Vegita", 77777),
                Map.entry("Picolo", 53636)
        );
        System.out.println(sortMapByValue(inputMap));
    }
}
