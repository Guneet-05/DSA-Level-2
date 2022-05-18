public class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    
    public int memo(int n, int k,int[] dp) {

        if(n <= 0) return 0;
        if(n == 1) return k;

        if(n == 2) return k*k;

        if(dp[n] != -1) return dp[n];

        int same = (n-2 >= 0) ?  memo(n-2,k,dp) * (k-1) : 0;
        int diff = (n-2 >= 0) ? memo(n-1,k,dp) * (k-1) : 0;

        return dp[n] = same + diff;
    }
    
    public int numWays(int n, int k) {
        // write your code here
        if(n <= 0) return 0;
        if(n == 1) return k;
        if(n == 2) return k*k;
        if(k == 1) return 0;
        
        int same = k;
        int diff = k*(k-1);

        for(int i=3;i<=n;i++) {
            int newSame = diff;
            int newDiff = (same + diff) * (k-1);
            same = newSame;
            diff = newDiff;
        }

        return same + diff;
    }
}
