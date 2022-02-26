class Solution {
    
     public List<List<Integer>> twoSumUnique(int[] nums, int target,int lo) {
        //array will already be sorted
        List<List<Integer>> ans = new ArrayList<>();
        int start = lo;
        int hi = nums.length-1;
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
    
    public List<List<Integer>> kSum(int[] nums, int start,int target,int k) {
        if(k == 2) {
            return twoSumUnique(nums,target,start);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i=start; i<= nums.length-k;i++) {
            if(i>start && nums[i] == nums[i-1]) continue;
            List<List<Integer>> subRes = kSum(nums,i+1,target-nums[i],k-1);
            for(List<Integer> sub : subRes) {
                sub.add(0,nums[i]);
                res.add(sub);
            }
        }
        
        return res;
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums,0,target,4);
    }
}
