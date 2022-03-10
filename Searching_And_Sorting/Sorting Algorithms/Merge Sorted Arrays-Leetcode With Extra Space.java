class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] c = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                c[k++] = nums1[i++];
            } else {
                c[k++] = nums2[j++];
            }
        }

        while(i < m) {
            c[k++] = nums1[i++];
        }

        while(j < nums2.length) {
            c[k++] = nums2[j++];
        }

        for(int x=0;x<c.length;x++) {
            nums1[x] = c[x];
        }
        
        
    }
}
