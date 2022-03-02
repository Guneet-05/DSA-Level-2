public class Solution {
    public int[] dNums(int[] A, int B) {
       HashMap<Integer,Integer> hm = new HashMap<>();
       int N = A.length;
       int K = B;
       
       for(int i=0;i<K;i++) {
           hm.put(A[i],hm.getOrDefault(A[i],0) + 1);
       }

       int[] ans = new int[N-K+1];
       ans[0] = hm.size();
       
       for(int i=1;i<=N-K;i++) {
           int oFreq = hm.get(A[i-1]);
           if(oFreq == 1) {
               hm.remove(A[i-1]);
           } else {
               hm.put(A[i-1],oFreq-1);
           }
           hm.put(A[i+K-1], hm.getOrDefault(A[i+K-1],0) + 1);
           ans[i] = hm.size();
       }

       return ans;
    }
}
