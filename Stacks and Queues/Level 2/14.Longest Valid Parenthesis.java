class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        
        int res = 0;
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(s.charAt(i) == '(') {
                stk.push(i);
            } else {
                if(stk.size() > 0 && s.charAt(stk.peek()) == '(') {
                    stk.pop();
                    
                } else {
                    stk.push(i);
                }
            }
            
            int j = (stk.size() == 0) ? -1 : stk.peek();
            res = Math.max(res,i-j);
        }
        
        return res;
    }
}
