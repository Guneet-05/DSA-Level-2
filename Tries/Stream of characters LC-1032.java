class StreamChecker {

    static class Node {
        private Node[] children = new Node[26];
        private boolean isEnd = false;
        
        boolean contains(char ch) {
            return (children[ch-'a'] != null) ;
        }
        
        void set(char ch) {
            children[ch-'a'] = new Node();
        }
        
        Node get(char ch) {
            return children[ch-'a'];
        }
        
        void setEnd() {
            isEnd = true;
        }
        
        boolean getEnd() {
            return isEnd;
        }
    }
    
    public void insert(Node root,String word) {
        Node curr = root;
        
        for(int i = word.length()-1;i>=0;i--) {
            char ch = word.charAt(i);
            if(curr.contains(ch) == false) {
                curr.set(ch);
            }
            curr = curr.get(ch);
        }
        
        curr.setEnd();
    }
    
    Node root;
    int maxLen = 0;
    public StreamChecker(String[] words) {
        root = new Node();
        for(String word : words) {
            insert(root,word);
            maxLen = Math.max(word.length(),maxLen);
        }
    }
    
    StringBuilder sb = new StringBuilder("");
    public boolean query(char letter) {
        sb.append(letter);
        
        Node curr = root;
        //here sb.length() - maxLen -1 is the length of the prefix
        //this means when prefix length is greater than the length of any word
        // then we have to stop
        for(int i=sb.length()-1;i>=Math.max(0,sb.length()-maxLen-1);i--) {
            if(curr.getEnd() == true) return true;
            char ch = sb.charAt(i);
            if(curr.contains(ch) == false) return false;
            curr = curr.get(ch);
        }
        if(curr.getEnd() == true) return true;
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
