package practice.streams;

import java.util.Comparator;
import java.util.stream.Collectors;

public class AnagramStrings {

    public static Boolean isAnagrams(String input1, String input2) {
        if (input1.length() != input2.length()) return false;
        return normalize(input1).equals(normalize(input2));
    }

    public static String normalize(String data) {
        return data.chars()
                .sorted()
                .collect(
                        StringBuilder::new, //Supplier	Provides empty builder
                        StringBuilder::appendCodePoint, //Accumulator	Appends each char code to builder
                        StringBuilder::append //Combiner	Merges two builders (if in parallel stream)
                ).toString();
    }

    public static String sortChars(String data){
        return data.toLowerCase().chars()
                .mapToObj(obj-> (char) obj)
                .sorted(Comparator.naturalOrder())
                .map(obj->String.valueOf(obj))
                .collect(Collectors.joining());
    }

    public static String sortCharsReverseOrder(String data){
        return data.toLowerCase().chars()
                .mapToObj(obj-> (char) obj)
                .sorted(Comparator.reverseOrder())
                .map(obj->String.valueOf(obj))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String input1 = "listen";
        String input2 = "silent";
        //String input2="silant";
        System.out.println(isAnagrams(input1, input2));

        String input = "Hello World";
        System.out.println(sortChars(input));

        System.out.println(sortCharsReverseOrder(input));
    }
}