class Solution {
    
    public static int mergeSort(int[] nums,int lo, int hi) {
        
        if(lo >= hi) {
            return 0;
        }
        
        int mid = (lo + hi) /2;
        //sort the left part
        int left = mergeSort(nums,lo,mid);
        //sort the right part
        int right = mergeSort(nums,mid + 1, hi);
        
        //merge the sorted parts in place
        int ans = merge(nums,lo,mid,mid+1,hi);
        
        return left + right + ans;
    }
    
     public static int merge(int[] nums, int a1l, int a1h, int a2l, int a2h) {
        int size = (int)(a1h-a1l+1l) + (int)(a2h-a2l+1l);
        int[] res = new int[size];
        int i=a1l,j=a2l,k=0;
        
        int invCount = 0; 
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
    
    
    int countSwaps(int nums[], int n) {
        // code here
        return mergeSort(nums,0,n-1);
    }
}
