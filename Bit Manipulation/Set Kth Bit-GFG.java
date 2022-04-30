class Solution{
    static int setKthBit(int N,int K){
        // code here
         int maskForSetting = (1 << K);
         int setBitNo = (N | maskForSetting);
         
         return setBitNo;
    }
}
