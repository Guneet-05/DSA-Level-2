class Solution {
    
    public List<List<Integer>> subsets(int[] nums,int idx) {
        if(idx == nums.length) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            return ans;
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> smallAns = subsets(nums, idx + 1);
        
        for(List<Integer> list : smallAns) {
            List<Integer> subset = new ArrayList<>();
            subset.add(nums[idx]);
            
            for(int x : list) {
                subset.add(x);
            }
            
            ans.add(subset);
            ans.add(list);
        }
        
        return ans;
        
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums,0);
    }
}
