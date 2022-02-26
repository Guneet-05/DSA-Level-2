public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int minimize(final int[] A, final int[] B, final int[] C) {
       int i = 0, j=0,k=0;
       int ans = Integer.MAX_VALUE;
       while(i<A.length && j<B.length && k<C.length) {
           int a = Math.abs(A[i] - B[j]), b = Math.abs(B[j] - C[k]),c = Math.abs(A[i] -C[k]);
           ans = Math.min(ans,Math.max(a,Math.max(b,c)));

           if(A[i] <= B[j] && A[i]<= C[k]) i++;
           else if(B[j] <= A[i] && B[j] <= C[k]) j++;
           else k++;
       }

       return ans;
    }
}
