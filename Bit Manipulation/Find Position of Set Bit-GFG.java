class Solution {
    static int findPosition(int N) {
        // code here
        int counter = 0;
        int temp = N;
        //kerninghan's algorithm
        while(temp != 0) {
            int rmsbm = (temp & -temp);
            temp -= rmsbm;
            counter++;
        }
        
        if(counter == 0 || counter > 1) return -1;
        
        int rmsbm = (N & -N);
        String res = Integer.toBinaryString(rmsbm);
        return res.length();
    }
};
