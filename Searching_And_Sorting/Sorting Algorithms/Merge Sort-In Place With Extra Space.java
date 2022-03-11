class Solution {
    
    public void mergeSort(int[] nums,int lo, int hi) {
        
        if(lo >= hi) {
            return;
        }
        
        int mid = (lo + hi) /2;
        //sort the left part
        mergeSort(nums,lo,mid);
        //sort the right part
        mergeSort(nums,mid + 1, hi);
        
        //merge the sorted parts in place
        merge(nums,lo,mid,mid+1,hi);
    }
    
    public void merge(int[] nums, int a1l, int a1h, int a2l, int a2h) {
        int size = (a1h-a1l+1) + (a2h-a2l+1);
        int[] res = new int[size];
        int i=a1l,j=a2l,k=0;
        
        while(i <= a1h && j<= a2h) {
            if(nums[i] <= nums[j]) {
                res[k++] = nums[i++];
            } else {
                res[k++] = nums[j++];
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
    }
    
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}
