class Solution {
    
    int twoSum(int[] arr, int target, int lo, int hi) {
        int ans = 0;
        
        while(lo < hi) {
            int sum = arr[lo] + arr[hi];
            if(sum == target) {
                lo++;
                hi--;
                ans++;
            } else if(sum < target) {
                lo++;
            } else {
                hi--;
            }
        }
        
        return ans;
    }
    
    int countTriplet(int arr[], int n) {
        // code here
        Arrays.sort(arr);
       int ans = 0;
       for(int i = n-1;i > 1;i--) {
          int twoSumPairs = twoSum(arr,arr[i],0,i-1);
          ans += twoSumPairs;
       }    
       
       return ans;
    }
}
