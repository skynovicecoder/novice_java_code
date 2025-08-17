package practice.dp;

public class LongestCommonSubsequence {
    public static int findLCS(String s1, String s2){
        /*
        This does not work for when order is rearranged
        int count=0;
        for(int i =0; i<s1.length(); i++){
            int temp=0;
            for(int j=temp; j<s2.length();j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    count++;
                    temp=j;
                    break;
                }
            }
        }
        return count;*/

        int[][] dp = new int[s1.length()+1][s2.length()+2];

        for(int i = s1.length()-1; i>=0; i--){
            for(int j= s2.length()-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j] = 1+ dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args){
        String input1="cat";
        String input2="crabt";
        System.out.println(findLCS(input1, input2)); //3

        String input3="abcd";
        String input4="abcd";
        System.out.println(findLCS(input3, input4)); //4

        String input5="abcd";
        String input6="efgh";
        System.out.println(findLCS(input5, input6)); //0

        String input7="abc";
        String input8="acb";
        System.out.println(findLCS(input7, input8)); //2


    }
}
