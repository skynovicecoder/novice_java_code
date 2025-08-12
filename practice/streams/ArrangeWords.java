package practice.streams;

import java.util.*;
import java.util.stream.Collectors;

public class ArrangeWords {

    public static void main(String[] args){
        List<String> wordsPool = new ArrayList<>(Arrays.asList("mango","men","aaam","arunanchal","apple", "hello", "arctic", "box", "rock", "hen"));

        Map<Character, List<String>> arrangedResult = wordsPool.stream()
                .collect(Collectors.groupingBy(
                        word -> Character.toLowerCase(word.charAt(0)), //classification function

                        //() -> new TreeMap<>(),
                        TreeMap::new, //map supplier

                        //Collectors.toList(), //downstream collector
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    //Collections.sort(list, (a,b) -> a.compareTo(b)),
                                    list.sort(String::compareTo);
                                            return list;
                                }
                        )
                ));

        System.out.println(arrangedResult);
        //{a=[aaam, apple, arctic, arunanchal], b=[box], h=[hello, hen], m=[mango, men], r=[rock]}
    }
}
