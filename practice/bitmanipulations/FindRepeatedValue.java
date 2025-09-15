package practice.bitmanipulations;

import java.time.Duration;
import java.time.LocalDateTime;

public class FindRepeatedValue {
    public static int findXOR(int[] inputArray){
        LocalDateTime start = LocalDateTime.now();
        int result = 0;
        for(int num : inputArray){
            result ^= num;
        }
        LocalDateTime end = LocalDateTime.now();
        Duration betweenTime = Duration.between(start, end);
        System.out.println("Time taken to complete findXOR : "+ betweenTime.toNanos());
        return result;
    }

    public static int usingBinary(int[] inputArray){
        LocalDateTime start = LocalDateTime.now();
        int low=0, high=inputArray.length-1;
        while(low<high){
            int mid = (low+high)/2;

            if(mid%2==1){
                mid--;
            }

            if(inputArray[mid] == inputArray[mid+1]){
                low = mid+2;
            }else{
                high=mid;
            }
        }
        LocalDateTime end = LocalDateTime.now();
        Duration betweenTime = Duration.between(start, end);
        System.out.println("Time taken to complete usingBinary : "+ betweenTime.toNanos());
        return inputArray[low];
    }

    public static void main(String[] args){
        int[] inputArray = {1,1,2,2,3,4,4,5,5};
        System.out.println(findXOR(inputArray));
        System.out.println(usingBinary(inputArray));
    }
}
