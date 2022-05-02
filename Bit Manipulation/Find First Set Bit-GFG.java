class Solution
{
    //Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n){
            
        // Your code here
        int rmsbm = (n & -n);
        String res = Integer.toBinaryString(rmsbm);
        
        if(res.equals("0") == true) return 0;
        
        return res.length();
    }
}
