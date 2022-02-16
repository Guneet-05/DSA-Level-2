// This is box on Level approach

import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int currentBox,int n, int k, int isf,String permutation,boolean[] vis){
    // write your code here
    if(currentBox == n) {
      if(isf == k) {
        System.out.println(permutation);
      }
      return;
    }

    //yes call for every item
    for(int i=1;i<=k;i++) {
       if(vis[i-1] == false) {
         vis[i-1] = true;
          permutations(currentBox + 1,n,k,isf + 1,permutation + i,vis);
          vis[i-1] = false;
       }
    }

    permutations(currentBox+1,n,k,isf,permutation + "0",vis);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());
    
    String str = "";
    boolean[] vis = new boolean[k];
    permutations(0,n,k,0,str,vis);
  }

}
