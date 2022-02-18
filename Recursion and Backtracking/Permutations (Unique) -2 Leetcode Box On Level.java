class Solution {
    
    List<List<Integer>> ans;
    
    public void permute(HashMap<Integer,Integer> fmap, int[] nums, int cBox,List<Integer> currPerm) {
        
        if(cBox == nums.length) {
            List<Integer> copy = new ArrayList<>(currPerm);
            ans.add(copy);
            return;
        }
        
        for(int key: fmap.keySet()) {
            if(fmap.get(key) > 0) {
                int freq = fmap.get(key);
                fmap.put(key,freq-1);
                currPerm.add(key);
                permute(fmap,nums,cBox + 1,currPerm);
                currPerm.remove(currPerm.size() - 1);
                fmap.put(key,freq);
            }
        }
        
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer,Integer> fmap = new HashMap<>();
        
        //fill the frequency map
        for(int i=0;i<nums.length;i++) {
            int oFreq = fmap.getOrDefault(nums[i],0);
            fmap.put(nums[i],oFreq + 1);
        }
        
        ans = new ArrayList<>();
        List<Integer> currPerm = new ArrayList<>();
        permute(fmap,nums,0,currPerm);
        return ans;
    }
}
