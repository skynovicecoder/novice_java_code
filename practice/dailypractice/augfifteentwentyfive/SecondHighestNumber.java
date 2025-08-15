package practice.dailypractice.augfifteentwentyfive;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SecondHighestNumber {
    public static int secondHighestNumber(int[] inputArray){
        int output = Arrays.stream(inputArray)
                .distinct()
                .boxed()
                .sorted((num1,num2)->num2-num1)
                .skip(1)
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("Illegal inputs"));
        return output;
    }

    public static Integer secondHighestInteger(List<Integer> inputList){
        Integer output = inputList.stream()
                .distinct()
                .sorted((a,b)->b-a)
                .skip(1)
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("Not valid inputs"));
        return output;
    }

    public static void main(String[] args){
        int[] inputArray = {10,20,60,70,30};
        System.out.println(secondHighestNumber(inputArray));

        List<Integer> listInteger = List.of(
                30,20,90,80,100
        );
        System.out.println(secondHighestInteger(listInteger));
    }
}
