package Searching_And_Sorting.Binary_Search.Codes;

// import java.util.*;

public class BinarySearch {

    public static void main(String[] args) {
        
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length -1;
          
         while(left <= right) {
             int mid = (left + right)/2;
             
             if(nums[mid] == target) {
                 return mid;
             } else if(nums[mid] < target) {
                 left = mid + 1;
             } else {
                 right = mid - 1;
             }
         } 
          
         return -1; //search unsuccessful 
      }
}