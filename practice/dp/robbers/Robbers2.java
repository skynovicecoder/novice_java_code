package practice.dp.robbers;

import java.util.Arrays;

public class Robbers2 {

    public static int rob(int[] nums){
        if(nums.length==0) return 0;
        return Math.max(
                helper(Arrays.copyOfRange(nums,1,nums.length)),
                helper(Arrays.copyOfRange(nums, 0,nums.length-1))
        );
    }

    public static int helper(int[] nums){
        if(nums.length==0) return 0;
        if (nums.length==1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i <nums.length; i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args){
        //int[] nums = {1,2,3,1};
        int[] nums = {2,7,9,3,1,5};
        System.out.println("Max Robbery Amount: "+rob(nums));

    }
}