package practice.dp.palindromes;

public class LongestPalindrome {
    public static String longestPalindromeString(String input){
        if(input == null || input.isBlank()) return "Empty";
        int resIndex=0;
        int resLength=0;

        for(int i =0; i<input.length(); i++){
            //For Odd Length
            int left=i,right=i;
            while(left>=0
                    && right<input.length()
                    && (input.charAt(left) == input.charAt(right))){
                if(right-left+1 > resLength){
                    resIndex = left;
                    resLength = right-left+1;
                }
                left--;
                right++;
            }

            //for Even length
            left=i;
            right=i+1;

            while(left>=0
                    && right<input.length()
                    && input.charAt(left) == input.charAt(right)){
                if(right-left+1 > resLength){
                    resIndex=left;
                    resLength=right-left+1;
                }
                left--;
                right++;
            }
        }

        return input.substring(resIndex, (resIndex+resLength));
    }

    public static void main(String[] args){
        String input = "ababd";
        System.out.println(longestPalindromeString(input));

        String input2 = "ababd";
        System.out.println(longestPalindromeString(input2));

        String input3 = "cbbd";
        System.out.println(longestPalindromeString(input3));
    }
}
