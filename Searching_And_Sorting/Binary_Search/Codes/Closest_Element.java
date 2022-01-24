public class Solution {
    public int closestElement(int[] arr, int target) {
        int ceil = lowerBound(arr,target);
        int floor = ceil-1;
        
        if(ceil == 0) return arr[ceil]; //floor does not exist
        if(ceil == arr.length) return arr[floor]; //ceil does not exist
    
        if(Math.abs(target-arr[floor]) <= Math.abs(target-arr[ceil])) {
            return arr[floor];
        }  
        
        return arr[ceil];
        
    }
    
}

