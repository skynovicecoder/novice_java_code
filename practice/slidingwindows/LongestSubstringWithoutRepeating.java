package practice.slidingwindows;

import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public static int longestSubstringWithoutRepeating(String input) {
        Set<Character> charSet = new LinkedHashSet<>();

        int left = 0, result = 0;

        for (int r = 0; r < input.length(); r++) {
            while (charSet.contains(input.charAt(r))) {
                charSet.remove(input.charAt(left));
                left++;
            }
            charSet.add(input.charAt(r));
            result = Math.max(result, charSet.size());
        }

        return result;

    }

    public static void main(String[] args) {
        String input = "zxyzxyz";
        //System.out.println(longestSubstringWithoutRepeating(input));

        String input1 = "xxxx";
        //System.out.println(longestSubstringWithoutRepeating(input1));

        String input2 = "abcabcbb";
        System.out.println(longestSubstringWithoutRepeating(input2));
    }
}
