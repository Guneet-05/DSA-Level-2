class Solution {
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m;i<m+n;i++) {
            nums1[i] = nums2[i - m];
        }
        
        for(int i=m;i<m+n;i++) {
            for(int j=i;j>0;j--) {
                if(nums1[j] < nums1[j-1]) {
                    swap(nums1,j,j-1);
                } else {
                    break;
                }
            }
        }
    }
}
