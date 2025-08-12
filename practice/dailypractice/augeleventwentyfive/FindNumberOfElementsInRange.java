package practice.dailypractice.augeleventwentyfive;

import java.util.Arrays;

public class FindNumberOfElementsInRange {

    public static int findIndex(int[] array, int num){
        int i=0,j=array.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(array[mid]<=num){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return i;
    }

    public static int findelementsInRange(int[] inputArray, int start, int last){
        Arrays.sort(inputArray);
        System.out.println("SortedArray : "+ Arrays.toString(inputArray));
        int startIndex = findIndex(inputArray, start);
        int lastIndex = findIndex(inputArray, last);
        return lastIndex-startIndex+1;
    }

    public static void main(String[] args){
        int[] inputArray = {1,3,5,2};
        System.out.println(findelementsInRange(inputArray, 1,5));

    }
}
