package practice.listarrays;

import java.util.*;

public class FindSumZero {

    public static boolean isSumZeroExists(int[] inputArray){
        Set<Integer> inputSet = new HashSet<>();
        int sum=0;
        for(int num : inputArray){
            sum+=num;
            if(sum==0 || inputSet.contains(sum)){
                return true;
            }
            inputSet.add(sum);
        }
        return false;
    }

    public static void printSubArraySumZero(int[] inputArray){
        Map<Integer, Integer> map = new HashMap<>();
        int sum=0;
        boolean found=false;
        for(int i =0; i<inputArray.length; i++){
            sum += inputArray[i];
            if(sum==0){
                List<Integer> getSubArray = subArray(inputArray, 0, i);
                System.out.println(getSubArray);
                found=true;
            }

            //if(map.get(sum)!=null){
            if(map.containsKey(sum)){
                List<Integer> getSubArray = subArray(inputArray, map.get(sum)+1, i);
                System.out.println(getSubArray);
                found=true;
            }
            map.put(sum,i);
        }
        if(!found){
            System.out.println("Not found: "+Collections.emptyList());
        }

    }

    public static List<Integer> subArray(int[] arr, int start, int end){
        List<Integer> result = new ArrayList<>();
        for(int i = start; i<=end; i++){
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args){
        int[] arr1 = {4, 2, -3, 1, 6};
        int[] arr2 = {1, 2, 3};
        //System.out.println(isSumZeroExists(arr1)); // true
        //System.out.println(isSumZeroExists(arr2)); // false

        int[] arr3 = {4, 2, -3, 1, 6};
        int[] arr4 = {1, 2, -3, 4, -1};
        int[] arr5 = {1, 2, 3};

        printSubArraySumZero(arr3); // [2, -3, 1]
        printSubArraySumZero(arr4); // [1, 2, -3]
        printSubArraySumZero(arr5); // Not Found: []
    }
}
