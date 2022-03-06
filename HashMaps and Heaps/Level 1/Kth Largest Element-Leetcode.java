class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = arr.length;
        for(int i=0;i<k;i++) {
            pq.add(arr[i]);
        }
        
        for(int i=1;i<=n-k;i++) {
            int incomingEle = arr[i + k -1];
            if(incomingEle > pq.peek()) {
                pq.remove();
                pq.add(incomingEle);
            }
        }
        
        return pq.peek();
    }
}
