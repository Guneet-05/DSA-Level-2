import java.io.*;
import java.util.*;

public class Main{

public static int fib(int n) {
    if(n == 0 || n == 1) {
        return n;
    }
    
    return fib(n-1) + fib(n-2);
}

public static int fibMemoized(int n,int[] dp) {
    
    if(n == 0 || n == 1) {
        return n;
    }
    
    if(dp[n] == -1) {
        int fib = fib(n-1) + fib(n-2);
        dp[n] = fib;
        return fib;
    }
    
    return dp[n];
}

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int[] dp= new int[n+1];
    Arrays.fill(dp,-1);
    System.out.println(fibMemoized(n,dp));
 }

}
