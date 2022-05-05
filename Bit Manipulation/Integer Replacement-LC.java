class Solution {
    public int integerReplacement(int n) {
       int res = 0;
       long temp = n; //this step is important
       //otherwise if Integer.MAX_VALUE is passed
        //adding 1 to it makes it negative
        //since it can't become + now
        //hence we will get TLE
        
        while(temp != 1) {
            if(temp % 2 == 0) {
                temp = temp/2;
            } else if(temp == 3) {
                temp = temp - 1;
            } else if(temp % 4 == 1) {
                temp = temp - 1;
            } else if(temp % 4 == 3) {
                temp = temp + 1;
            }
            res++;
        }
        
        return res;
    }
}
