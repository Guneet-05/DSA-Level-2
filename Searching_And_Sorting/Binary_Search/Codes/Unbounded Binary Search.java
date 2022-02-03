import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
    }
    
    public static int binarySearch(int[] arr, int lo, int hi, int target) {
        
        if(lo > hi) return -1; //unsuccessful search
        
        int mid = lo +(hi-lo)/2;
        
        if(arr[mid] == target) return mid;
        else if(arr[mid] > target) return binarySearch(arr,lo,mid - 1,target);
        else return binarySearch(arr,mid + 1,hi,target);
    }
    
    //This method will be invoked as binarySearchInfinite(arr,0,1,target)
    
    public static binarySearchInfinite(int[] arr, int lo, int hi, int target) {
        
        if(lo > hi) return -1; //this line will never execute as lo will never be less than high in case of unsuccessful search 
        
        if(target >= arr[lo] && target <= arr[hi]) {
            return binarySearch(arr,lo,hi,target);
        } else {
            binarySearchInfinite(arr,hi + 1,hi * 2,target);
        }
    }
}
