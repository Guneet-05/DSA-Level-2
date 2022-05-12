import java.io.*;
import java.util.*;

public class Main {

    public static int solve(int n) {
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for(int i=1;i<dp.length;i++) {
            int res1 = dp[i-1];
            int res2 = (i - 2 >= 0) ? dp[i - 2] : 0;
            int res3 = (i - 3 >= 0) ? dp[i - 3] : 0;
            dp[i] = res1 + res2 + res3;
        }
        
        return dp[n];
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solve(n));
    }

}
