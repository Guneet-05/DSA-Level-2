class Solution{
    
    // Function to find number of bits needed to be flipped to convert A to B
    public static int countBitsFlip(int a, int b){
        
        // Your code here
        int xor = (a ^ b);
        
        int hDist = 0;
        while(xor != 0) {
            int rmsbm = (xor & -xor);
            xor -= rmsbm;
            hDist++;
        }
        
        return hDist;
        
    }
    
    
}
