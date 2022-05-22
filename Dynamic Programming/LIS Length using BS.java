class Solution {
    
    public int getCeil(ArrayList<Integer> list, int lo, int hi,int target) {
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(list.get(mid) == target) return mid;
            else if(list.get(mid) < target) lo = mid + 1;
            else hi = mid -1;
        }
        
        return lo;
    }
    
    public int lengthOfLIS(int[] nums) {
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        
        for(int i=1;i<nums.length;i++) {
            if(nums[i] > list.get(list.size() -1)) {
                list.add(nums[i]);
            } else {
                int ceilIndex = getCeil(list,0,list.size()-1,nums[i]);
                list.set(ceilIndex,nums[i]);
            }
        }
        
        return list.size();
    }
}
