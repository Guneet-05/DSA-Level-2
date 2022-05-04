public class Solution {
    public int solve(int[] A, int B) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        int res = 0;
        for(int i=0;i<A.length;i++) {
            if(hm.getOrDefault(A[i] ^ B,0) != 0) res++;
            hm.put((A[i]),1);   
        }

        return res;
    }
}
