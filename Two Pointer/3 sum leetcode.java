class Solution {
    
    public List<List<Integer>> twoSumUnique(int[] nums, int target,int lo, int hi) {
        //array will already be sorted
        List<List<Integer>> ans = new ArrayList<>();
        int start = lo;
        while(lo < hi) {
            List<Integer> smallAns = new ArrayList<>();
            if(lo > start && nums[lo - 1] == nums[lo]) {
                lo++;
                continue;
            }
            
            int sum = nums[lo] + nums[hi];
            if(sum == target) {
                smallAns.add(nums[lo]);
                smallAns.add(nums[hi]);
                lo++;
                hi--;
            } else if(sum < target) {
                lo++;
            } else {
                hi--;
            }
            
            if(smallAns.size() > 0) ans.add(smallAns);
        }
        return ans;
    }
    
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            
            int target = 0 - nums[i];
            if(i>0 && nums[i-1] == nums[i]) continue;
            
            List<List<Integer>> targetSumPairs = twoSumUnique(nums,target,i+1,nums.length-1);
            for(List<Integer> tsp : targetSumPairs) {
                tsp.add(0,nums[i]);
                ans.add(tsp);
            }
        }
        
        return ans;
    }
}
