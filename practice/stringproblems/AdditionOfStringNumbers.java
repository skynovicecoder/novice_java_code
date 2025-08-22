package practice.stringproblems;

public class AdditionOfStringNumbers {
    public static String addNumbers(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int carry = 0;

        while (len1 >= 0 || len2 >= 0 || carry > 0) {
            int digit1 = (len1 >= 0) ? num1.charAt(len1) - '0' : 0;
            int digit2 = (len2 >= 0) ? num2.charAt(len2) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.append(sum % 10);

            len1--;
            len2--;

        }


        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "1234";
        String num2 = "567";

        System.out.println(addNumbers(num1, num2));
    }
}
