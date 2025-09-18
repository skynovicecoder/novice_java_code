package practice.streams;

import java.util.Arrays;
import java.util.List;

public class MapVsFlatMap {

    public static void map(){
        List<String> words = List.of("java", "spring", "docker");

        List<Integer> lengths = words.stream()
                .map(String::length)   // each word → its length
                .toList();

        System.out.println(lengths); // [4, 6, 6]
    }

    public static void  flatMap(){
        //FLAT MAP:
        List<String> sentences = List.of("java is fun", "streams are powerful");

        List<String> wordsList = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .toList();

        System.out.println(wordsList);
        // [java, is, fun, streams, are, powerful]
    }

    public static void main(String[] args){
        // Transforms each element into one value
        // Returns a Stream of the same size (1 input → 1 output)
        map();

        //Transforms each element into a Stream (or collection)
        //Then flattens all those streams into a single stream
        //Useful when 1 input → multiple outputs
        flatMap();
    }
}
