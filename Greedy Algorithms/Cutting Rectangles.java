class Solution{
    
    
    public static long euclidean(long a, long b) {
        if(b == 0) return a;
        return euclidean(b, a%b);
    }
    
    static List<Long> minimumSquares(long L, long B)
    {
        // code here
        long dimen =  euclidean(L,B);
        long noOfSquares = (L*B) / (dimen * dimen);
        List<Long> res = new ArrayList<>();
        res.add(noOfSquares);
        res.add(dimen);
        return res;
    }
}
