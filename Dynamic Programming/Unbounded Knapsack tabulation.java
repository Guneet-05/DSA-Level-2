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
    static int knapSack(int N, int caps, int cost[], int wt[])
    {
        // code here
        int[][] dp = new int[N + 1][caps + 1];
    
        for(int item=1;item<dp.length;item++) {
            for(int cap = 0;cap <= caps;cap++) {
                int no = dp[item-1][cap];
                int yes = (cap >= wt[item - 1]) ? 
                dp[item][cap-wt[item-1]] + cost[item-1] : -1;
            
                dp[item][cap] = Math.max(yes,no);
            } 
        }
        
        return dp[N][caps];
    }
}
