package practice.greedy;

public class MaxSubArray {
    public static int maxSubArraySum(int[] inputArray){
        // O(n)3
        /*int max=0;
        for(int i =0;i<inputArray.length;i++){
            for(int j=i;j<inputArray.length;j++){
                int sum = 0;
                for(int k=i;k<=j;k++){
                    sum+=inputArray[k];
                }
                max=Math.max(sum,max);
            }
        }*/

        // O(n)2
        /*int max=inputArray[0];

        for(int i =0;i<inputArray.length;i++){
            int sum=0;
            for(int j=i;j<inputArray.length;j++){
                sum+=inputArray[j];
                max=Math.max(sum,max);
            }
        }*/
        int[][] dp = new int[inputArray.length+1][2];
        dp[inputArray.length-1][1]=dp[inputArray.length-1][0]=inputArray[inputArray.length-1];
        for(int i=inputArray.length-2;i>=0;i--){
            dp[i][1] = Math.max(inputArray[i], inputArray[i]+dp[i+1][1]);
            dp[i][0] = Math.max(dp[i+1][0], dp[i][1]);
        }
        return dp[0][0];
    }
    public static void main(String[] args){
        int[] input = {2,-3,4,-2,2,1,-1,4};
        System.out.println(maxSubArraySum(input)); //8
    }
}
