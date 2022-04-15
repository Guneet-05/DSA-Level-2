class Solution {
    
    static class Node {
        private Node[] children = new Node[26];
        private boolean isEnd = false;
        
        boolean contains(char ch) {
            if(children[ch-'a'] != null) return true;
            return false;
        }
        
        Node get(char ch) {
            return children[ch-'a'];
        }
        
        void set(char ch) {
            children[ch-'a'] = new Node();
        }
        
        void setEnd() {
            isEnd = true;
        }
        
        boolean getEnd() {
            return isEnd;
        }
    }
    
     public void insert(Node root, String word) {
        Node curr = root;
        
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(curr.contains(ch) == false) {
                curr.set(ch);
            }
            curr = curr.get(ch);
        }
        
        curr.setEnd();
    }
    
    String res = "";
    public void dfs(Node curr,String asf) {
            
        int count = 0;
        char c = '0';
        
        if(asf.length() > res.length()) res = asf;
    
        if(curr.getEnd() == true) return;

        
        for(char ch='a';ch<='z';ch++) {
            if(curr.contains(ch) == true) {
                c = ch;
                count++;
            }
        }
        
        if(count == 1)
            dfs(curr.get(c),asf + c);
        
    
    } 
    
    public String longestCommonPrefix(String[] strs) {
        Node root = new Node();
        for(String str: strs) {
            insert(root,str);
        }
        dfs(root,"");
        return res;
    }
}
