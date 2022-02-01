class Solution {
    public int shipWithinDays(int[] arr, int m) {
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

            if(isPossible(arr,mid,m) == true) {
                pa = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return pa;
    }
    
    public boolean isPossible(int[] nums, int maxSum, int m) {
        
        int subArrays = 1;
        int sum = 0;
        
        for(int i=0;i<nums.length;i++) {
            if(sum + nums[i] <= maxSum) {
                sum += nums[i];
            } else {
                sum = nums[i];
                subArrays++;
            }
        }
        
        if(subArrays <= m) return true;
        return false;
    }
    
}
