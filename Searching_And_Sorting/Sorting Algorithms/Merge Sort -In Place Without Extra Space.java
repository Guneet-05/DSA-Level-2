 private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
//modify this merge method to merge 2 arrays in a single array (Shell Sort)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m;i<m+n;i++) {
            nums1[i] = nums2[i - m];
        }
        
        
        for(int gap = (m + n + 1)/2;gap>=1;gap = gap/2) {
             for(int i=0,j =gap;j< m + n;i++,j++) {
                 if(nums1[i] > nums1[j]) {
                     swap(nums1,i,j);
                 }
             }   
        }
        
        for(int i=0,j =1;j< m + n;i++,j++) {
            if(nums1[i] > nums1[j]) {
                swap(nums1,i,j);
            }
        } 
    }
}
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
