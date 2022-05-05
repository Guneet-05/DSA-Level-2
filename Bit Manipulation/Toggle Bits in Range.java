class Solution {
    static int toggleBits(int N , int L , int R) {
        // code here
        int mask = ((1 << R) - 1) ^ ((1 << (L - 1)) - 1);
        N = N ^ mask;
        return N;
    }
};
