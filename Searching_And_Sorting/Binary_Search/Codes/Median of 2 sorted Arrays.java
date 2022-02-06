class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) 
            return findMedianSortedArrays(nums2,nums1);
        
        int lo = 0;
        int hi = nums1.length;
        int N = (nums1.length + nums2.length);
        int Nby2 = (N + 1) / 2;
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            
            int al = (mid -1 >= 0) ? nums1[mid - 1] : Integer.MIN_VALUE;
            int ar = (mid < nums1.length) ? nums1[mid] : Integer.MAX_VALUE;
            int bl = (Nby2 - mid -1 >= 0) ? nums2[Nby2 - mid -1] : Integer.MIN_VALUE;
            int br = (Nby2 - mid < nums2.length) ? nums2[Nby2 - mid] : Integer.MAX_VALUE;
            
            if(al <= br && bl <= ar) {
                //return median
                if(N % 2 == 1) {
                    return Math.max(al,bl);
                } else {
                    int[] arr = {al,bl,ar,br};
                    Arrays.sort(arr);
                    return (arr[1] + arr[2])/2.0;
                    
                }
            }
            
            else if(al > br) {
                hi = mid -1;
            } else {
                lo = mid + 1;
            }
        }
        
        return 0.0;
    }
}
