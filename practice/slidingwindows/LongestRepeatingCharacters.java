package practice.slidingwindows;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacters {

    public static int longestRepeatingCharactersLength(String input, int allowedReplacements) {
        HashMap<Character, Integer> alphabetMap = new HashMap<>();
        int res = 0;

        int l = 0;
        for (int r = 0; r < input.length(); r++) {
            alphabetMap.put(input.charAt(r), alphabetMap.getOrDefault(input.charAt(r), 0) + 1);

            int maxFrequency = maxCount(alphabetMap);

            while ((r - l + 1) - maxFrequency > allowedReplacements) {
                alphabetMap.put(input.charAt(l), alphabetMap.get(input.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public static int maxCount(Map<Character, Integer> map) {
        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .orElseGet(() -> 0);
    }

    public static void main(String[] args) {
        String input = "XYYX";
        int allowedReplacements = 2;
        System.out.println(longestRepeatingCharactersLength(input, allowedReplacements));

        String input1 = "AAABABB";
        int allowedReplacements1 = 1;
        System.out.println(longestRepeatingCharactersLength(input1, allowedReplacements1));
    }
}
