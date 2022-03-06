class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> hm = new HashMap<>();
        
        for(int i=0;i<nums.length;i++) {
            hm.put(nums[i],true);
        }
        
        for(int key: hm.keySet()) {
            if(hm.containsKey(key-1) == true) {
                hm.put(key,false);
            }
        }
        
        int maxLen = 0;
        for(int key: hm.keySet()) {
            if(hm.get(key) == true) {
                int x = key;
                int len = 1;
                while(hm.containsKey(x + 1) == true) {
                   len++;
                    x = x + 1;
                }
                maxLen = Math.max(maxLen,len);
            }
        }
        
        return maxLen;
    }
}
