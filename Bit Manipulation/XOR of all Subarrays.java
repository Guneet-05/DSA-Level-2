public class Solution {
    public int solve(int[] A) {
       int ans = 0;
       for(int i=0;i<A.length;i++) {
           int contri = (i+1)*(A.length-i);
           if(contri % 2 != 0) ans = ans ^ A[i];
       }
       return ans;
    }
}
