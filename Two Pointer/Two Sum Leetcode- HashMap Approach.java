class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> fmap = new HashMap<>();
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        
        for(int i=0;i<nums.length;i++) {
            int oFreq = fmap.getOrDefault(nums[i],0);
            fmap.put(nums[i],oFreq + 1);
            indexMap.put(nums[i],i);
        }
        
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++) {
            int complement = target - nums[i];
            if(nums[i] * 2 == target) {
                if(fmap.get(nums[i]) >= 2) {
                    ans[0] = i;
                    ans[1] = indexMap.get(nums[i]);
                    return ans;
                }
            } 
            else {
             
                if(fmap.containsKey(complement) == true) {
                    ans[0] = i;
                    ans[1] = indexMap.get(complement);
                    Arrays.sort(ans);
                    return ans;
                }   
            }
            
        }
        
        return ans;
    }
}
