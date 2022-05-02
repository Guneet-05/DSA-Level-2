class Solution {
    public int hammingDistance(int x, int y) {
        int xor = (x ^ y);
        
        int hDist = 0;
        while(xor != 0) {
            int rmsbm = (xor & -xor);
            xor -= rmsbm;
            hDist++;
        }
        
        return hDist;
    }
}
