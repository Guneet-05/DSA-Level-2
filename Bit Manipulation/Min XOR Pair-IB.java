public class Solution {
    public int findMinXor(int[] A) {
        Arrays.sort(A);

        int minVal = Integer.MAX_VALUE;

        for(int i=0;i<A.length -1;i++) {
            int xor = (A[i] ^ A[i+1]);
            minVal = Math.min(minVal,xor); 
        }

        return minVal;
    }
}
