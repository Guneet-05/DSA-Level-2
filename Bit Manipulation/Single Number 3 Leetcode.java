class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor = 0;
        for(int val : nums) {
            xor = xor ^ val;
        }
        
        int rmsbm = (xor & -xor);
        int x = 0;
        int y = 0;
        
        for(int val : nums) {
            if((val & rmsbm) != 0) {
                x = x ^ val;
            } else {
                y = y ^ val;
            }
        }
        
        return new int[]{x,y};
    }
}
