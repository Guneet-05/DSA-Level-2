import java.io.*;
import java.util.*;

public class Main {

    public static int solve(int n,int[] dp) {
        
        if(n == 0) return 1;
        if(dp[n] != -1) return dp[n];
        
        int res1 = (n - 1 >= 0) ? solve(n-1,dp) : 0;
        int res2 = (n - 2 >= 0) ? solve(n-2,dp) : 0;
        int res3 = (n - 3 >= 0) ? solve(n-3,dp) : 0;
        
        return dp[n] = res1 + res2 + res3;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        System.out.println(solve(n,dp));
    }

}
