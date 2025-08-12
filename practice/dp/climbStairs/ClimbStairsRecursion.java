package practice.dp.climbStairs;

public class ClimbStairsRecursion {

    public static int climbStairs(int n){
        return dfs(n,0);
    }

    public static int dfs(int n , int i){
        if(i>=n) return i==n ? 1:0;
        return dfs(n,i+1) + dfs(n,i+2);
    }

    public static void main(String[] args){
        int stairsCount=20;
        System.out.println("For "+stairsCount+" Stairs, it has possible ways: "+climbStairs(stairsCount));
    }
}
