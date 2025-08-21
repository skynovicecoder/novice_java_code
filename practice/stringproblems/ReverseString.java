package practice.stringproblems;

public class ReverseString {

    public static String reverseString(String str) {
        int length = str.length();
        char[] reverseString = new char[length];

        for (int i = length - 1; i >= 0; i--) {
            reverseString[length - 1 - i] = str.charAt(i);
        }

        return new String(reverseString);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Hello"));
    }

}
