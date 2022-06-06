class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int idx = 0;
        for(int i=0;i<nums.length;i++) {
            //remove first
            if(q.size() > 0 && q.getFirst() <= i-k) {
                q.removeFirst();
            }
            
            //removeLast those elements that are smaller than us
            while(q.size() > 0 && nums[q.getLast()] < nums[i]) {
                q.removeLast();
            }
            
            //addLast -> we may be the answer of current or upcoming windows
            q.addLast(i);
            
            if(i >= k-1) {
                res[idx++] = nums[q.getFirst()];
            }
        }
        
        return res;
    }
}
