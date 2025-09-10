package practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> result;

    public static List<List<Integer>> findComboSum(int[] inputArray, int target) {
        result = new ArrayList<>();
        Arrays.sort(inputArray);

        dfs(0, new ArrayList<>(), 0, inputArray, target);
        return result;
    }

    public static void dfs(int i, List<Integer> cur, int total, int[] inputArray, int target) {
        if (total == target) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int j = i; j < inputArray.length; j++) {
            if (total + inputArray[j] > target) {
                return;
            }
            cur.add(inputArray[j]);
            dfs(j, cur, total + inputArray[j], inputArray, target);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{2, 3, 5, 6, 7};
        int target = 7;
        System.out.println(findComboSum(inputArray, target));
    }
}
