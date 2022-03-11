class Solution
{
    public static long mergeSort(long[] nums,int lo, int hi) {
        
        if(lo >= hi) {
            return 0l;
        }
        
        int mid = (lo + hi) /2;
        //sort the left part
        long left = mergeSort(nums,lo,mid);
        //sort the right part
        long right = mergeSort(nums,mid + 1, hi);
        
        //merge the sorted parts in place
        long ans = merge(nums,lo,mid,mid+1,hi);
        
        return left + right + ans;
    }
    
    public static long merge(long[] nums, int a1l, int a1h, int a2l, int a2h) {
        int size = (int)(a1h-a1l+1l) + (int)(a2h-a2l+1l);
        long[] res = new long[size];
        int i=a1l,j=a2l,k=0;
        
        long invCount = 0l; 
        while(i <= a1h && j<= a2h) {
            if(nums[i] <= nums[j]) {
                res[k++] = nums[i++];
            } else {
                res[k++] = nums[j++];
                invCount += (a1h - i + 1l);
            }
        }
        
        while(i<= a1h) {
            res[k++] = nums[i++];
        }
        
        while(j<= a2h) {
            res[k++] = nums[j++];
        }
        
        for(int x=a1l;x<=a2h;x++) {
            nums[x] = res[x-a1l];
        }
        
        return invCount;
    }
    
    // public int[] sortArray(int[] nums) {
    //     mergeSort(nums,0,nums.length-1);
    //     return nums;
    // }
    
    static long inversionCount(long arr[], long N)
    {
        return mergeSort(arr,0,(int)N-1);
    }
}
