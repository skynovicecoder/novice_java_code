package practice.dailypractice.augsixtwentyfive;

import java.util.Arrays;
import java.util.Comparator;

public class Sentence {
    public static String analyzeString(String input){
        String [] inputArray = input.split(" ");
        return Arrays.stream(inputArray)
                .max(Comparator.comparingInt(String::length))
                .orElse("");

    }
    public static void main(String[] args){
        String input = "Java Stream API is powerful tool for data process";
        System.out.println(analyzeString(input));
    }
}