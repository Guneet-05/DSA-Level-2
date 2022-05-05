class Solution{
    static int swapNibbles(int N) {
        //code here
       int mask1 = (1 << 4) - 1;
       //System.out.println("mask1 " + Integer.toBinaryString(mask1));
       int nibble1 = (N & mask1);
       //System.out.println("nibble1 " + Integer.toBinaryString(nibble1));
       int nibble2 = ((N - nibble1) >> 4);
       //System.out.println("nibble2 " + Integer.toBinaryString(nibble2));
       
       nibble1 = (nibble1 << 4);
       //System.out.println("nibble1 " + Integer.toBinaryString(nibble1));
       int res = (nibble1 + nibble2);
       return res;
    }
}
