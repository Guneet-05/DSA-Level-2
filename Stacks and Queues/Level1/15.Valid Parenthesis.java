class Solution {
    public boolean isValid(String str) {
         Stack<Character> st = new Stack<>();
       
       for(int i=0;i<str.length();i++) {
           char ch = str.charAt(i);
           
           if(ch == '(' || ch == '[' || ch == '{') {
               st.push(ch);
           } else if(ch == ')' || ch == ']' || ch == '}') {
               if(st.size() == 0) return false;
               
               if(ch == ')') {
                  char top = st.pop();
                  if(top != '(') return false;
               } else if(ch == ']') {
                   char top = st.pop();
                   if(top != '[') return false;
               } else {
                   char top = st.pop();
                   if(top != '{') return false;
               }
           }
       }
       
       if(st.size() > 0) return false;
       return true;
    }
}
