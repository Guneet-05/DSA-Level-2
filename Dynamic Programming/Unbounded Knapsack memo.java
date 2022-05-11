//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
     static int memo(int idx,int cap,int wt[], int cost[],int N, int[][] dp) {
        
        if(idx == N || cap == 0) return 0;
        
        if(dp[idx][cap] != -1) return dp[idx][cap];
        
        int no = memo(idx + 1,cap,wt,cost,N,dp);
        
        int yes = (cap >= wt[idx]) ? cost[idx] + memo(idx,cap-wt[idx],wt,cost,N,dp)
        : -1;
        
        return dp[idx][cap] = Math.max(yes,no);
    }
    
    static int knapSack(int N, int cap, int cost[], int wt[])
    {
        // code here
        int[][] dp = new int[N + 1][cap + 1];
        for(int i=0;i<=N;i++) {
            for(int j=0;j<=cap;j++) {
                dp[i][j] = -1;
            }
        }
        
        return memo(0,cap,wt,cost,N,dp);
    }
}
