class MapSum {

    static class Node {
        private Node[] children = new Node[26];
        private int val = 0;
        
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
        
        void setVal(int val) {
            this.val = val;
        }
        
        int getVal() {
            return val;
        }
    }
    
    Node root;
    
    public MapSum() {
        root = new Node();
    }
    
    public void insert(String key, int val) {
        Node curr = root;
        
        for(int i=0;i<key.length();i++) {
            char ch = key.charAt(i);
            if(curr.contains(ch) == false) {
                curr.set(ch);
            }
            
            curr = curr.get(ch);
        }
        
        curr.val = val;
    }
    
    private int DFS(Node curr) {
        int ans = 0;
        
        for(char ch='a';ch<='z';ch++) {
            if(curr.contains(ch) == true) {
                ans += DFS(curr.get(ch));
            }
        }
        
        ans += curr.getVal();
        return ans;
    }
    
    public int sum(String prefix) {
        Node curr = root;
        
        for(int i=0;i<prefix.length();i++) {
            char ch = prefix.charAt(i);
            if(curr.contains(ch) == false) return 0;
            curr = curr.get(ch);
        }
        
        return DFS(curr);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
