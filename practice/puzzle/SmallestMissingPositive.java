package practice.puzzle;

public class SmallestMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ) {
            int val = nums[i];
            // place val at index val-1 if it's in range and not already in correct place
            if (val >= 1 && val <= n && nums[val - 1] != val) {
                swap(nums, i, val - 1);
            } else {
                i++;
            }
        }

        // first index i where nums[i] != i+1 is the missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // quick main to demo
    public static void main(String[] args) {
        int[][] tests = {
                {3, 4, -1, 1},
                {1, 2, 0},
                {7, 8, 9, 11, 12},
                {1, 1}
        };
        for (int[] t : tests) {
            System.out.printf("input: %s -> missing: %d%n", java.util.Arrays.toString(t), firstMissingPositive(t.clone()));
        }
    }
}
