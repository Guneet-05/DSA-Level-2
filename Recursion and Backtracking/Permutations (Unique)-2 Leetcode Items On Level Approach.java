class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public void permute(int currItem,List<Integer> perm,HashMap<Integer,Integer> lastIdx, int[] nums) {
        if(currItem == nums.length) {
            List<Integer> copy = new ArrayList<>(perm);
            ans.add(copy);
            return;
        }
        
        int li = lastIdx.get(nums[currItem]);
        
        for(int i=li + 1;i<perm.size();i++) {
            if(perm.get(i) == null) {
                perm.set(i,nums[currItem]);
                lastIdx.put(nums[currItem],i);
                
                permute(currItem + 1,perm,lastIdx,nums);
                
                lastIdx.put(nums[currItem],li);
                perm.set(i,null);
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer,Integer> lastIdx = new HashMap<>();
        //every elements last index should be -1 initially
        for(int i=0;i<nums.length;i++) {
            lastIdx.put(nums[i],-1);
        }
        
        //fill this initially with null
        List<Integer> perm = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            perm.add(null);
        }
        
        ans = new ArrayList<>();
        permute(0,perm,lastIdx,nums);
        return ans;
    }
}
