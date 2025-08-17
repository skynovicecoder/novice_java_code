package practice.dp;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    public static int countDecodeWays(String s) {
        int[] dp = new int[s.length()+1];
        dp[s.length()]=1;

        for(int i =s.length()-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                dp[i]=0;
            }else {
                dp[i] = dp[i + 1];
                if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        String input = "1012";
        System.out.println(countDecodeWays(input)); //2

        String input2 = "121";
        System.out.println(countDecodeWays(input2)); //3

        String input3 = "12";
        System.out.println(countDecodeWays(input3)); //2

        String input4 = "01";
        System.out.println(countDecodeWays(input4)); //0
    }
}