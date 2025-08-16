package practice.dp.palindromes;

public class PalindromicSubstrings {
    public static int palindromicSubstringsCounts(String inputString){
        if(inputString == null || inputString.isBlank()) return 0;
        int count=0;

        for(int i =0;i<inputString.length(); i++){

            //even length
            int left=i, right=i;
            while(left>=0
                    && right<inputString.length()
                    && inputString.charAt(left)==inputString.charAt(right)){
                count+=1;
                left--;
                right++;
            }

            //odd length
            left=i;
            right=i+1;
            while(left>=0
                    && right<inputString.length()
                    && inputString.charAt(left)==inputString.charAt(right)){
                count+=1;
                left--;
                right++;
            }
        }

        return count;
    }

    public static void main(String[] args){
        String input="aaa";
        System.out.println(palindromicSubstringsCounts(input));

        String input1="abc";
        System.out.println(palindromicSubstringsCounts(input1));
    }
}
