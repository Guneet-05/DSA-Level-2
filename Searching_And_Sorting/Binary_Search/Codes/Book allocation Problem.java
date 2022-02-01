import java.util.*;
import java.io.*;

public class Main {

  private static boolean isPossible(int maxLoad,int[] arr, int students) {
    int st = 1;
    int pg = 0;
    
    for(int i=0;i<arr.length;i++) {
        if(pg + arr[i] <= maxLoad) {
            pg += arr[i];
        } else {
            st++;
            pg = arr[i];
        }
    }
    
    if(st <= students) return true;
    return false;
  }

  public static int minPages(int[]arr, int m) {
    //write your code here
    int max = Integer.MIN_VALUE;
    int sum = 0;
    
    for(int i=0;i<arr.length;i++) {
        if(arr[i] > max) max = arr[i];
        
        sum += arr[i];
    }
    
    int lo = max;
    int hi = sum;
    int pa = 0;
    
    while(lo <= hi) {
        int mid = lo + (hi-lo)/2;
        
        if(isPossible(mid,arr,m) == true) {
            pa = mid;
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return pa;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int m = scn.nextInt();

    int ans = minPages(arr, m);
    System.out.println(ans);
  }
}
