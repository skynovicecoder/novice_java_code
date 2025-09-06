package practice.lists;

import java.util.*;

public class ReverseList {
public static void main(String[] args) {
List<Integer> input = new ArrayList<>(Arrays.asList(23,10,8,3,12));
System.out.println("Input : "+input);

//Collections.reverse(input);
//System.out.println(input);

    /*List<Integer> reversed = input.stream()
            .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                        Collections.reverse(list);
                        return list;
                    }));
    System.out.println(reversed);*/

    /*int[] numArray = input.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    System.out.println(Arrays.toString(numArray));
    for(int i =0; i<numArray.length/2; i++){
        int x = numArray[numArray.length-1-i];
        numArray[numArray.length-1-i] = numArray[i];
        numArray[i] = x;
    }
    System.out.println(Arrays.toString(numArray));*/

    for(int i =0, j=input.size()-1;i<j;i++,j--){
        int temp = input.get(i);
        input.set(i, input.get(j));
        input.set(j,temp);
    }
    System.out.println("Output:: "+input);

}

}