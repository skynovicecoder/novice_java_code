package practice.bitmanipulations;

public class ReverseBits {
    public static int reverseBitNumber(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if (((1 << i) & n) != 0) {
                builder.append("1");
            } else {
                builder.append("0");
            }
        }

        int res = 0;
        String reversedBinary = builder.reverse().toString();
        for (int i = 0; i < 32; i++) {
            if (reversedBinary.charAt(i) == '1') {
                res = res | (1 << i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 21;
        int result = reverseBitNumber(num);
        //Expected : 2818572288 for input=21
        System.out.println("Reversed number after inverting the bits is :: " + Integer.toUnsignedString(result));
    }
}
