package practice.bitmanipulations;

import java.util.Arrays;

public class CountingBits {
    public static int[] countingBits(int n) {
        int[] output = new int[n + 1];

         /*for(int i=0;i<=n;i++){
             output[i] = Integer.bitCount(i);
         }*/

           /* for (int i = 0; i <= n; i++) {
                int num=i;
                int res = 0;
                while (num != 0) {
                    num = num & (num - 1);
                    res++;
                }
                output[i] = res;
            }*/

        /*for (int num = 0; num <= n; num++) {
            int count = 0;
            for (int j = 0; j < 32; j++) {
                if ((num & (1 << j)) != 0) {
                    count++;
                }
            }
            output[num] = count;
        }*/

        for (int i = 0; i <= n; i++) {
            int num = i;
            int count = 0;
            while (num > 0) {
                if (num % 2 == 1) {
                    count++;
                }
                num = num / 2;
            }
            output[i] = count;
        }

        return output;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Number of Bits :: " + Arrays.toString(countingBits(n)));
    }

}
