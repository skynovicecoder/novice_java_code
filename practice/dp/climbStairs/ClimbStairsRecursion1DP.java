package practice.dp.climbStairs;

public class ClimbStairsRecursion1DP {
    static long[] cache;
    public static long climbStairs(int n){
        cache = new long[n];
        for(int i=0; i<n ;i++){
            cache[i] = -1;
        }
        return dfs(n,0);
    }
    public static long dfs(int n , int i){
        if(i>=n) return i==n?1:0;
        if(cache[i]!=-1) return cache[i];

        return cache[i] = dfs(n, i+1)+dfs(n,i+2);

    }

    public static void main(String[] args){
        int stairsCount=5;
        System.out.println("For "+stairsCount+" Stairs, it has possible ways: "+climbStairs(stairsCount));
    }
}
