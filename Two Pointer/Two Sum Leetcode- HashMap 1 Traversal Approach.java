class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        int[] ans = new int[2];
        
        for(int i=0;i<nums.length;i++) {
            int comp = target - nums[i];
            if(indexMap.containsKey(comp) == false) {
                indexMap.put(nums[i],i);
            } else {
                ans[0] = indexMap.get(comp);
                ans[1] = i;
                break;
            }
        }
        
        return ans;
    }
}
