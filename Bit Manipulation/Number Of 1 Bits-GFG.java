class Solution {
    static int setBits(int N) {
        // code here
        int counter = 0;
        while(N != 0) {
            int rmsbm = (N & -N);
            N -= rmsbm;
            counter++;
        }
        
        return counter;
    }
}
