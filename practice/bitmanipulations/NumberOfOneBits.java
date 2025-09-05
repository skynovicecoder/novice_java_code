package practice.bitmanipulations;

public class NumberOfOneBits {
    public static int countOneBitsByJava(int num){
        return Integer.bitCount(num);
    }

    public static int countOneBitsUsingBitwiseLeftShift(int num){
        int result = 0;
        for(int i=0;i<32;i++){
            if(((1 << i) & num) != 0){
             result++;
            }
        }
        return result;
    }

    public static int UsingBitsOperation(int num){
        int res = 0;
        while(num != 0){
            num = num & (num-1);
            res++;
        }

        return res;
    }

    public static int usingModulusOfTwo(int num){
        int result = 0;
        while(num>0){
            if(num%2==1){
                result++;
            }
            num = num/2;
        }
        return result;
    }

    public static void main(String[] args){
        int input = 13;
        System.out.println("\ncountOneBitsByJava :: "+countOneBitsByJava(input));

        System.out.println("\ncountOneBitsUsingBitwiseLeftShift :: "+countOneBitsUsingBitwiseLeftShift(input));

        System.out.println("\nUsingBitsOperation :: "+UsingBitsOperation(input));

        System.out.println("\nusingModulusOfTwo :: "+usingModulusOfTwo(input));
    }
}
