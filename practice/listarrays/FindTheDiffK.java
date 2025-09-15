package practice.listarrays;

import java.util.HashSet;
import java.util.Set;

public class FindTheDiffK {
    public static int[] findTheNumsWithDiffKInSortedArray(int[] inputArray, int k){
        int i=0, j=1;

        while(i< inputArray.length && j< inputArray.length){
            int diff = inputArray[j]-inputArray[i];
            if(i != j && diff==k){
                return new int[]{i,j};
            }
            if(diff<k){
                j++;
            }else{
                i++;
            }
        }
        return new int[]{-1,-1};
    }

    public static int[] findTheNumsWithDiffK(int[] inputArray, int k){
        Set<Integer> seen = new HashSet<>();
        for(int num: inputArray){
            if(seen.contains(num+k)){
                return new int[]{num, num+k};
            }
            if(seen.contains(num-k)){
                return new int[]{num-k,num};
            }
            seen.add(num);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args){
        int[] inputArray = {2,4,10,15,17};
        int k=7;
        //int[] result = findTheNumsWithDiffKInSortedArray(inputArray, k);
        //int firstNum = result[0]!=-1 ? inputArray[result[0]] : -1;
       //int secondNum = result[1]!=-1 ? inputArray[result[1]] : -1;

        int[] result = findTheNumsWithDiffK(inputArray, k);
        int firstNum = result[0];
        int secondNum = result[1];
        System.out.println("Numbers are :"+ firstNum +" and " + secondNum);
    }

}
