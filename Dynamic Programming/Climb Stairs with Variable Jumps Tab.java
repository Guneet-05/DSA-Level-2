import java.io.*;
import java.util.*;

public class Main {

    public static int tab(int[] jumps,int n) {
        
        int[] dp = new int[n + 1];
        dp[n] = 1;
        
        for(int i=n-1;i>=0;i--) {
            for(int js=1;js<=jumps[i];js++) {
                int smallAns = (i + js < dp.length) ? dp[i + js] : 0;
                dp[i] += smallAns;
            }
        }
        
        return dp[0];
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] jumps = new int[n];
        
        for(int i=0;i<n;i++) {
            jumps[i] = scn.nextInt();
        }
        
        System.out.println(tab(jumps,n));
    }

}
