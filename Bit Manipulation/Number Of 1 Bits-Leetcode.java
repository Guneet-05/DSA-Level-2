public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int counter = 0;
        while(n != 0) {
            int rmsbm = (n & -n);
            n -= rmsbm;
            counter++;
        }
        
        return counter;
    }
}
