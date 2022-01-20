package Searching_And_Sorting.Binary_Search.Codes;

import java.util.Scanner;
public class BrokenEconomy {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++) {
            arr[i] = scn.nextInt();
        }
        
        int d = scn.nextInt();
        
        ceilAndFloor(arr,d);
        scn.close();
     }
     
     public static void ceilAndFloor(int[] arr, int target) {
         int ceil = Integer.MAX_VALUE; //bado me sabse chota
         int floor = Integer.MIN_VALUE; //choto me sabse bada
         
         int lo = 0;
         int hi = arr.length-1;
         
         while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            
            if(arr[mid] == target) {
                ceil = arr[mid];
                floor = arr[mid];
                break;
            } else if(arr[mid] < target) {
                if(arr[mid] > floor) {
                    floor = arr[mid];
                }
                lo = mid + 1;
            } else {
                if(arr[mid] < ceil) {
                    ceil = arr[mid];
                }
                hi = mid - 1;
            }
         }
         
         System.out.println(ceil);
         System.out.println(floor);
     }
}
