package practice.dp;

public class WordBreak {

    public static boolean operateWordBreak(String inputString, String[] wordDict){
        boolean[] dp = new boolean[inputString.length()+1];
        dp[inputString.length()] = true;

        for(int i=inputString.length()-1;i>=0;i--){
            for(String word : wordDict){
                if(i+word.length()<=inputString.length()
                        && inputString.substring(i,i+word.length()).equals(word)){
                    dp[i] = dp[i+word.length()];
                }

                if(dp[i]){
                    break;
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args){
        String input="neetcode";
        String[] wordDict = {"neet", "code"};

        System.out.println(operateWordBreak(input, wordDict)); //true

        String input2="applepenapple";
        String[] wordDict2 = {"apple","pen","ape"};

        System.out.println(operateWordBreak(input2, wordDict2)); //true

        String input3="catsincars";
        String[] wordDict3 = {"cats","cat","sin","in","car"};

        System.out.println(operateWordBreak(input3, wordDict3)); //false
    }
}
