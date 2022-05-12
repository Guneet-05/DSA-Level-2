import java.io.*;
import java.util.*;

public class Main {

    public static int memo(int[] jumps, int currStair,int[] dp) {
        
       if(currStair == jumps.length) return 1;  
       if(dp[currStair] != -1) return dp[currStair]; 
        
       int res = 0;
       for(int js=1;js<=jumps[currStair];js++) {
           int smallRes = (currStair + js <= jumps.length) ? memo(jumps,currStair + js,dp) : 0;
           res += smallRes;
       }
       
       return dp[currStair] = res;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] jumps = new int[n];
        
        for(int i=0;i<n;i++) {
            jumps[i] = scn.nextInt();
        }
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        System.out.println(memo(jumps,0,dp));
    }

}
