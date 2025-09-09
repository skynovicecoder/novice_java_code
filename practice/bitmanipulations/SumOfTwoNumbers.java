package practice.bitmanipulations;

public class SumOfTwoNumbers {

    public static int findSumWithoutOperators(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1; //calculate carry
            a = a ^ b; //sum without carry
            b = carry;
        }

        return a;
    }

    public static void main(String[] args) {
        int a = -5;
        int b = -6;
        System.out.println("\nSum of two number is:: " + findSumWithoutOperators(a, b));

        int a1 = -5;
        int b1 = 6;
        System.out.println("\nSum of two number is:: " + findSumWithoutOperators(a1, b1));

        int a2 = 3;
        int b2 = 4;
        System.out.println("\nSum of two number is:: " + findSumWithoutOperators(a2, b2));
    }
}
