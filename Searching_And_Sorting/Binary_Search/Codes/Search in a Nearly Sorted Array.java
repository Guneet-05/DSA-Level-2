import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        //input the array
        
        int[] arr = new int[n];
        
        for(int i=0;i<arr.length;i++) arr[i] = scn.nextInt();
        
        int target = scn.nextInt();
        
        System.out.println(search(arr,k,target));
    }
    
    public static int search(int[] arr,int k,int target) {
       int lo = 0;
       int hi = arr.length-1;
       
       while(lo <= hi) {
           int mid = lo + (hi-lo)/2;
           
           int lVal = (mid-1 >= 0) ? arr[mid - 1] : Integer.MIN_VALUE;
           int rVal = (mid + 1 < arr.length) ? arr[mid + 1]  : Integer.MAX_VALUE;
           
           if(arr[mid] == target) return mid;
           else if(lVal == target) return mid - 1;
           else if(rVal == target) return mid + 1;
           
           if(arr[mid] > target) hi = mid-2;
           else lo = mid + 2;
       }
       
       return -1;
    }
}
