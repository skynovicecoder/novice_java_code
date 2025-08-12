package practice.dp;

import java.math.BigInteger;

public class Factorial {
    public static BigInteger fact(int num){
        //Note: Integer support 12 , long support till 20 only fact, rest we have to go for Big Integer,
        //similarly as we do for fibonacci as only till 46 for int, 92 for long, after that we have to use BigInteger

        if(num<0) return BigInteger.valueOf(-1);

        //return num*fact(num-1);
        BigInteger result = BigInteger.ONE;

        for(int i=2; i<=num; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(fact(0));
    }
}
