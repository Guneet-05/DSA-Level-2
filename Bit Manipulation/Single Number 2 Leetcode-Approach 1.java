class Solution {
    public int singleNumber(int[] nums) {
        int[] res = new int[32];
        
        for(int i=0;i<=31;i++) {
            
            int count1 = 0;
            for(int val : nums) {
                int mask  = (1 << i);
                int bit = (val & mask);
                if(bit != 0) count1++;
            }
            
            res[i] = count1;
        }
        
        int ans = 0;
        for(int i=0;i<32;i++) {
            if(res[i] % 3 != 0) {
                ans += (1 << i);
            }
        }
        
        return ans;
    }
}
