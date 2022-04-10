import java.io.*;
import java.util.*;

public class Main {
    
    public static void dfs(int[][] arr, int sr, int sc) {
        
        if(sr < 0 || sr >= arr.length || sc < 0 || sc >= arr[0].length) return;
        
        if(arr[sr][sc] == -1 || arr[sr][sc] == 1) return; //return if already visited or water
        
        //mark visited
        arr[sr][sc] = -1;
        
        dfs(arr,sr - 1,sc); //up call
        dfs(arr, sr, sc + 1); //right call
        dfs(arr, sr + 1,sc); //down call
        dfs(arr,sr, sc - 1); //left call
    }
    
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      // write your code here
      int count = 0;
      
      for(int i=0;i<arr.length;i++) {
          for(int j=0;j<arr[0].length;j++) {
            if(arr[i][j] != -1 && arr[i][j] != 1) {
                dfs(arr,i,j);
                count++;
            }  
          }
      }
      
      System.out.println(count);
   }

}
