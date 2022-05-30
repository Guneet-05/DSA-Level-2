class Solution {
    
//     Radix Sort karna hai 
//     Yaani har digit pe count sort
//     Since integer me max 10 digits honge
//     TC -> O(10 * N) 
//     SC -> O(N)
    
    void countSort(int[] nums,int exp) {
        int n = nums.length;
        int[] output = new int[n];
        int[] count = new int[10];
        
        for(int i=0;i<n;i++)
            count[(nums[i]/ exp) % 10]++;
        
        for(int i=1;i<10;i++) {
            count[i] += count[i-1];
        }
        
        for(int i=n-1;i>=0;i--) {
            output[count[(nums[i] / exp) % 10] - 1] = nums[i];
            count[(nums[i] / exp) % 10]--;
        }
        
        for(int i=0;i<n;i++)
            nums[i] = output[i];
    }
    
    public int maximumGap(int[] nums) {
        if(nums.length <= 1) return 0;
        
        //Radix Sort
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            max = Math.max(max,nums[i]);
        }
        
        for(int exp=1;max/exp > 0; exp*= 10) {
            countSort(nums,exp);
        }
        
        int res = 0;
        for(int i=0;i<n-1;i++) {
            res = Math.max(res,nums[i+1] - nums[i]);
        }
        
        return res;
    }
}
