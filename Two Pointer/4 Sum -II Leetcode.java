class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> AB =  new HashMap<>();
        //store the sum of pair vs count
        for(int val1: nums1)
            for(int val2: nums2)
                AB.put(val1 + val2,AB.getOrDefault(val1 + val2,0) + 1);
        
        int count = 0;
        for(int val3: nums3) {
            for(int val4: nums4) {
                int target = -val3 - val4;
                count += AB.getOrDefault(target,0);
            }
        }
        
        return count;
            
    }
}
