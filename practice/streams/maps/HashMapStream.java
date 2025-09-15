package practice.streams.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HashMapStream {

    public static void main(String[] args){
        Map<Integer, Map<String, Integer>> orderInfo = new HashMap<>();
        orderInfo.put(1, Map.of("apple",10,"banana",5));
        //orderInfo.put(2, Map.of("banana",6,"oranges",5));
        orderInfo.put(2, Map.ofEntries(
                        Map.entry("banana",6),
                        Map.entry("oranges",5)
                ));
        System.out.println(orderInfo);

       /* List<Map<String, Integer>> itemList = orderInfo.values().stream()
                .collect(Collectors.toList());

        System.out.println(itemList);*/

        /*List<Map.Entry<String,Integer>> itemList = orderInfo.values().stream()
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toList());
        System.out.println(itemList);*/

        /*Map<String, Integer> itemList = orderInfo.values().stream()
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Integer::sum
                ));
        System.out.println(itemList);*/

        /*Optional<Map.Entry<String, Integer>> itemList = orderInfo.values().stream()
                .flatMap(map -> map.entrySet().stream())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                Integer::sum
                        )).entrySet().stream()
                        .max(Map.Entry.comparingByValue());
        System.out.println(itemList);
        itemList.ifPresent(System.out::println);*/

        /*Optional<Integer> itemList = orderInfo.values().stream()
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Integer::sum
                )).entrySet().stream()
                .map(Map.Entry::getValue)
                        .max(Integer::compareTo);
        System.out.println(itemList);
        itemList.ifPresent(System.out::println);*/

        Map<String, Integer> itemList = orderInfo.values().stream()  //All values stream
                .flatMap( map -> map.entrySet().stream()) //flatten map
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.summingInt(Map.Entry::getValue)
                ));

        Optional<Map.Entry<String,Integer>> result = itemList.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        result.ifPresent(System.out::println);

    }
}
