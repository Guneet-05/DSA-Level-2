class Solution{
    static String getBinaryRep(int N){
        // code here
        int temp = N;
        String res = ""; 
        while(temp > 0) {
            int rem = temp % 2;
            temp = temp / 2;
            res = "" + rem + res;
        }
        
        int len = res.length();
        int limit = 30-len;
        
        for(int i=1;i<=limit;i++) {
            res = "0" + res;
        }
        
        return res;
    }
}
