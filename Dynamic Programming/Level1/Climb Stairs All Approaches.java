import java.io.*;
import java.util.*;

public class Main {

    public static int paths(int n) {
        //negative base case
        if(n < 0) {
            return 0;
        }
        
        //positive base case
        if(n == 0) {
            return 1;
        }
        
        int pathsnm1 = paths(n-1);
        int pathsnm2 = paths(n-2);
        int pathsnm3 = paths(n-3);
        
        return pathsnm1 + pathsnm2 + pathsnm3;
    }
    
    public static int pathsMem(int n, int[] dp) {
        
        if(n == 0) return 1;
        
        if(dp[n] != -1) return dp[n];
        
        int pathsnm1 = 0;
        int pathsnm2 = 0;
        int pathsnm3 = 0;
        
        //pruning 
        if(n-1 >= 0) {
            pathsnm1 = pathsMem(n-1,dp);
        }
        
        //pruning
        if(n-2 >= 0) {
            pathsnm2 = pathsMem(n-2,dp);
        }
        
        //pruning
        if(n-3 >= 0) {
            pathsnm3 = pathsMem(n-3,dp);
        }
        
        int pathsn = pathsnm1 + pathsnm2 + pathsnm3;
        dp[n] = pathsn; //memoization
        
        return pathsn;
    }
    
    public static int tabulation(int n) {
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        
        
        for(int i=1;i<dp.length;i++) {
            if(i==1) {
                dp[i] = dp[i-1];
            } else if(i==2) {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }
        
        return dp[n];
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        System.out.println(tabulation(n));
    }

}
