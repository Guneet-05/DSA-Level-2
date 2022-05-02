class Solution {
    public int totalHammingDistance(int[] nums) {
        long res = 0;
        
        for(int i=0;i<32;i++) {
            long counton = 0;
            
            for(int val : nums) {
                int bit = ((val & (1 << i)) == 0) ? 0 : 1;
                if(bit == 1) {
                    counton++;
                }
            }
            
            long countoff = nums.length - counton;
            long curr = counton * countoff;
            res += curr;
        }
        
        return (int)res;
    }
}
