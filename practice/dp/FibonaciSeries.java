package practice.dp;

public class FibonaciSeries {

    public static int fib(int num){
        if(num<=2) {
            return 1;
        }

        //return fib(num-1)+fib(num-2); //this does not uses memoization, using memoization solving bellow

        int[] memo = new int[num+1];
        memo[1]=1;
        memo[2]=1;

        for(int i=3;i<=num;i++){
            memo[i] = memo[i-1]+memo[i-2];
        }

        return memo[num];

    }

    public static void main(String[] args){
        System.out.println(fib(6));
    }
}