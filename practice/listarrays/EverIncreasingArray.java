package practice.listarrays;

public class EverIncreasingArray {

    public static boolean alwaysIncreasing(int[] inputArray){
        if (inputArray == null || inputArray.length==0) return true;

        /*int[] dp = new int[inputArray.length+1];
        dp[0] = 0;
        for(int i=0; i < inputArray.length; i++){
            dp[i+1] = dp[i]+inputArray[i];
            if(!(inputArray[i]>dp[i])){
                return false;
            }
        }*/

        int sumSoFar=0;
        for(int num : inputArray){
            if(num<=sumSoFar){
                return false;
            }
            sumSoFar+=num;
        }

        return true;
    }

    public static void main(String[] args){
        int[] arr1={1,2,3,4};
        int[] arr2={2,3,6,12};
        int[] arr3={2,3,6,10};

        System.out.println("First Input : " +alwaysIncreasing(arr1)); //false
        System.out.println("Second Input : " +alwaysIncreasing(arr2)); //true
        System.out.println("Third Input : " +alwaysIncreasing(arr3)); //false
    }
}
