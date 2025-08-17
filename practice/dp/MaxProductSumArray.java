package practice.dp;

public class MaxProductSumArray {
    public static int calMaxProdContiguousSubArray(int[] inputArray){
        if(inputArray == null || inputArray.length==0) return Integer.MIN_VALUE;

        int res=inputArray[0];
        int currMax=1, currMin=1;

        for(int num : inputArray){
            int temp = currMax*num;
            currMax = Math.max(Math.max(currMax*num, currMin*num), num);
            currMin = Math.min(Math.min(temp, currMin*num), num);
            res = Math.max(res, currMax);
        }

        return res;
    }

    public static void main(String[] args){
        int[] input1={1,2,-3,4};
        System.out.println(calMaxProdContiguousSubArray(input1)); //4

        int[] input2={-2,-1};
        System.out.println(calMaxProdContiguousSubArray(input2));  //2

        int[] input3={1,2,3};
        System.out.println(calMaxProdContiguousSubArray(input3));  //6

        int[] input4={-1,-2,-3};
        System.out.println(calMaxProdContiguousSubArray(input4));  //6

        int[] input5={};
        System.out.println(calMaxProdContiguousSubArray(input5));  //Integer.MIN_VALUE

        int[] input6=null;
        System.out.println(calMaxProdContiguousSubArray(input6));  //Integer.MIN_VALUE

        int[] input7={-1,-2,-3,-4,0,3,4};
        System.out.println(calMaxProdContiguousSubArray(input7));  //24

    }
}
