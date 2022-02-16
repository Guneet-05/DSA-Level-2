class Solution {
    
    public void permutations(int currBox,int[] nums,List<Integer> curr, List<List<Integer>> ans,boolean[] vis) {
        if(currBox == nums.length) {
            List<Integer> list = new ArrayList<>(curr); //deep copy
            ans.add(list);
            return;   
        }
        
        //only yes calls because items = boxes
        
        for(int i=0;i<nums.length;i++) {
            if(vis[i] == false) {
                vis[i] = true; //item nums[i] added to the box
                curr.add(nums[i]);
                permutations(currBox + 1,nums,curr,ans,vis);
                curr.remove(curr.size() - 1);
                vis[i] = false;
            }
        }
        
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        permutations(0,nums,curr,ans,vis);
        return ans;
    }
}
