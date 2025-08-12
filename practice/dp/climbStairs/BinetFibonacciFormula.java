package practice.dp.climbStairs;

public class BinetFibonacciFormula {

    //log n time complexity
    public static int climbStairs(int n){
        double sqrt5 = Math.sqrt(5);
        double phi = (1+sqrt5)/2;  //Golden ratio (Golden ratio ≈ 1.618)
        double psi = (1-sqrt5)/2;  //Golden ratio negative Counter-part (≈ -0.618)

        n++;

        return (int) Math.round(Math.round(Math.pow(phi,n)-Math.pow(psi,n))/sqrt5);
    }

    public static void main(String[] args){
        int stairsCount=10; //Note: int support till 46 and double 92, for higher use BigInteger
        System.out.println("For "+stairsCount+" Stairs, it has possible ways: "+climbStairs(stairsCount));
    }
}
