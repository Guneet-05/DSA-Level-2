public class Solution {
    public int solve(int[] arr, int target) {
        int n = arr.length;
        boolean[] dp = new boolean[target + 1];
	    dp[0] = true;
	    
	    for(int i=1;i<=n;i++) {
	        boolean[] newDp = new boolean[target + 1];
	        for(int j=0;j<=target;j++) {
	            boolean no = dp[j];
	            boolean yes = (j >= arr[i - 1]) ? dp[j-arr[i-1]] : false;
	            
	            newDp[j] = (no || yes);
	        }
	        dp = newDp;
	    }
	    
	    return (dp[target] == true) ? 1 : 0;
    }
}
