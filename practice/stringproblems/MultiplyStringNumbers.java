package practice.stringproblems;

public class MultiplyStringNumbers {

    public static String multiply(String num1, String num2) {
        // Handle zero cases
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int n1 = num1.length();
        int n2 = num2.length();
        int[] result = new int[n1 + n2]; // max length of product

        // Multiply each digit (from right to left)
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                int mul = digit1 * digit2;

                int posLow = i + j + 1;
                int posHigh = i + j;

                mul += result[posLow]; // add previous carry/sum
                result[posLow] = mul % 10;
                result[posHigh] += mul / 10; // carry forward
            }
        }

        // Convert int[] to string (skip leading zeros)
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) { // skip leading zeros
                sb.append(num);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "45"));        // Output: 5535
        System.out.println(multiply("999", "999"));       // Output: 998001
        System.out.println(multiply("123456789", "987654321")); // Output: 121932631112635269
    }
}
