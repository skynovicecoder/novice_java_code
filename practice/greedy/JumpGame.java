package practice.greedy;

public class JumpGame {
    public static boolean checkJumpGameValidity(int[] inputArray){
        /*int goal = inputArray.length-1;
        for(int i =inputArray.length-1;i>=0;i--){
            if(i+inputArray[i]>=goal){
                goal=i;
            }
        }
        return goal==0;*/

        // using dp bottom-up
        int n = inputArray.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;
        for(int i = n-2;i>=0;i--){
            int end = Math.min(inputArray.length, i+inputArray[i]+1);
            for(int j=i+1;j<end;j++){
                if(dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args){
        int[] input ={1,2,0,1,0};
        System.out.println(checkJumpGameValidity(input));

        int[] input1 ={1,2,1,0,1};
        System.out.println(checkJumpGameValidity(input1));

        int[] input2 ={1,2,3,0,1};
        System.out.println(checkJumpGameValidity(input2));
    }
}