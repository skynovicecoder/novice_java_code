package practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumEvenNumbers {
    public static void sum(List<Integer> numbers) {
        int sumOfEvens = numbers.stream()
                .filter(n -> n % 2 == 0)   // keep only even numbers
                .mapToInt(Integer::intValue)
                //.mapToInt(Integer::valueOf)
                .sum();
        System.out.println("Sum of even numbers using IntStream: " + sumOfEvens);
    }

    public static void add(List<Integer> numbers) {
        int sumOfEvens = numbers.stream()
                .filter(n -> n % 2 == 0)
                //.reduce(0, (a,b)->a+b);
                .reduce(0, Integer::sum);
        System.out.println("Sum of even numbers using Reduce: " + sumOfEvens);
    }

    public static void addition(List<Integer> numbers) {
        int sumOfEvens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Sum of even numbers using Collectors: " + sumOfEvens);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 1. One Way using Int Stream
        sum(numbers);

        // 2. Second way using Reduce
        add(numbers);

        // 3. Third way using collectors
        addition(numbers);
    }
}