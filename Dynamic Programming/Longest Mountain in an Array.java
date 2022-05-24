class Solution {
    public int longestMountain(int[] arr) {
        int[] left = new int[arr.length];
        //Longest Increasing Subarray Ending at i
        Arrays.fill(left,1);
        for(int i=0;i<arr.length;i++) {
            if(i > 0 && arr[i - 1] < arr[i]) {
                left[i] = left[i-1] + 1;
            } 
        }
        
        //Longest Decreasing Subarray ending at i
        int[] right = new int[arr.length];
        Arrays.fill(right,1);
        
        for(int i=arr.length-2;i>=0;i--) {
            if(arr[i] > arr[i+1]) {
                right[i] = right[i+1] + 1;
            }
        }
        
        int max = 0;
        for(int i=0;i<arr.length;i++) {
            if(left[i] > 1 && right[i] > 1) {
                max = Math.max(max,left[i] + right[i] -1);
            }
        }
        
        return max;
    }
    
}
