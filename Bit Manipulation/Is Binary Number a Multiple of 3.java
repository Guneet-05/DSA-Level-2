class Solution {
    int isDivisible(String s) {
        // code here
        int odd = 0;
        int even = 0;
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(i % 2 == 0)
                even += ch -'0';
            else
                odd += ch - '0';
        }
        
        int delta = even - odd;
        if(delta % 3 == 0) return 1;
        return 0;
    }
}
