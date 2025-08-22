package practice.stringproblems;

public class SusbtractionOfStringNumbers {
    public static String substractNumber(String s1, String s2) {
        boolean negative = false;
        if (isSmaller(s1, s2)) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
            negative = true;
        }

        StringBuilder result = new StringBuilder();
        int len1 = s1.length() - 1;
        int len2 = s2.length() - 1;
        boolean borrowFlag = false;

        while (len1 >= 0 || len2 >= 0) {
            int digit1 = (len1 >= 0) ? s1.charAt(len1) - '0' : 0;
            int digit2 = (len2 >= 0) ? s2.charAt(len2) - '0' : 0;

            if (borrowFlag) {
                digit1 = digit1 - 1;
                borrowFlag = false;
            }
            if (digit1 < digit2) {
                digit1 = digit1 + 10;
                borrowFlag = true;
            }
            int sub = digit1 - digit2;

            result.append(sub);

            len1--;
            len2--;
        }

        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }

        String finalResult = result.reverse().toString();
        return negative ? "-" + finalResult : finalResult;
    }

    private static boolean isSmaller(String s1, String s2) {
        if (s1.length() != s2.length())
            return s1.length() < s2.length();
        return s1.compareTo(s2) < 0;
    }

    public static void main(String[] args) {
        String input1 = "167";
        String input2 = "584";

        System.out.println(substractNumber(input1, input2));
    }


}
