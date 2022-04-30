class CheckBit
{
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k)
    {
        // Your code here
         int maskForChecking = (1 << k);
         
         if((n & maskForChecking) != 0) {
            return true; //bit was set
         } 
         
         return false;
    }
    
}
