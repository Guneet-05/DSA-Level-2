import java.io.*;
import java.util.*;

public class Main {
        
    public static long partitionKSubset(int n, int k,long[][] dp) {
        // write your code here
        if(n < k || k == 0) return 0l;
        if(n == 1) {
            if(k == 1) return 1l;
            return 0l;
        }

        if(dp[n][k] != -1) return dp[n][k];

        long share = partitionKSubset(n-1,k,dp);
        long newRoom = partitionKSubset(n-1,k-1,dp);

        return dp[n][k] = ((share * k) + newRoom);
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long[][] dp = new long[n+1][k+1];

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=k;j++) {
                dp[i][j] = -1;
            }
        }

        long res = partitionKSubset(n, k,dp);
        System.out.println(res);
    }
}
