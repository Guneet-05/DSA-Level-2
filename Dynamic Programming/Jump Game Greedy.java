//The DP approach gives TLE Hence greedy should be applied
class Solution {
    public boolean canJump(int[] nums) {
       int reach = 0;
       
       int idx = 0;
       
        while(idx < nums.length) {
            
            if(idx > reach) return false;
            
            int currReach = idx + nums[idx];
            reach = Math.max(reach,currReach);
            idx++;
        }
        
        if(reach >= nums.length-1) return true;
        
        return false;
    }
}
