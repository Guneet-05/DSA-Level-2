class Solution {
    public int singleNumber(int[] arr) {
        int tn = -1, tnp1 = 0, tnp2 = 0;
   
        for(int i=0;i<arr.length;i++) {
            int sbcw3n = (arr[i] & tn);
            int sbcw3np1 = (arr[i] & tnp1);
            int sbcw3np2 = (arr[i] & tnp2);
 
 
            tn = (tn & (~sbcw3n));
            tnp1 = (tnp1 | sbcw3n);
 
            tnp1 = (tnp1 & (~sbcw3np1));
            tnp2 = (tnp2 | sbcw3np1);
 
            tnp2 = (tnp2 & (~sbcw3np2));
            tn = (tn | sbcw3np2);
        }
        
        return tnp1;
    }
}
