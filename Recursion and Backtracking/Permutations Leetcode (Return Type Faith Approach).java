class Solution {
    
    public List<List<Integer>> permute(int[] nums, int idx) {
        
        if(nums == null || nums.length == 0) return new ArrayList<>();
        
        if(idx == nums.length) {
            List<List<Integer>> baseRes = new ArrayList<>();
            baseRes.add(new ArrayList<>());
            return baseRes;
        }
        
        List<List<Integer>> smallAns = permute(nums,idx + 1);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(List<Integer> smallPerm : smallAns) {
            for(int i=0;i<=smallPerm.size();i++) {
                List<Integer> copy = new ArrayList<>(smallPerm);
                copy.add(i,nums[idx]);
                ans.add(copy);
            }
        }
        
        return ans;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums,0);
    }
}
