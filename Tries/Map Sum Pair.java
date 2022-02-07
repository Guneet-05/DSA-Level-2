class MapSum {

    public static class Node {
        private int val = 0;
        private Node[] children = new Node[26];
        private int pref = 0;
        
        public Node get(char ch) {
            return children[ch-'a'];
        }
        
        public void setVal(int val) {
            this.val = val;
        }
        
        public int getVal() {
            return val;
        }
        
        public void set(char ch) {
            children[ch-'a'] = new Node();
        }
        
        public boolean contains(char ch) {
            if(children[ch-'a'] == null) return false;
            return true;
        }
        
    }
    
    Node root;
    
    public MapSum() {
        root = new Node();
    }
    
    private int search(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(curr.contains(ch) == false)
               return 0;
            
            curr = curr.get(ch);
        }
        
        return curr.getVal();
            
    }
    
    public void insert(String key, int val) {
        int oVal = search(key);
        Node curr = root;
        for(int i=0;i<key.length();i++) {
            
            curr.pref += (val-oVal); 
            char ch = key.charAt(i);
            if(curr.contains(ch) == false)
               curr.set(ch);
            
            curr = curr.get(ch);
        }
        
        curr.pref += (val-oVal);
        curr.setVal(val);
            
    }
    
    public int sum(String prefix) {
        Node curr = root;
        for(int i=0;i<prefix.length();i++) {
            char ch = prefix.charAt(i);
            if(curr.contains(ch) == false)
                return 0;
            
            curr = curr.get(ch);
        }
        
        return curr.pref;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
