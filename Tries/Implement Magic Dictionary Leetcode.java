class MagicDictionary {

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
    
    Node root;
    
    public MagicDictionary() {
        root = new Node();
    }
    
    private void insert(String word) {
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
    
    public void buildDict(String[] dictionary) {
        
        for(String word : dictionary) {
            insert(word);
        }
    }
    
    public boolean search(String word,int idx,Node curr, boolean change) {
        
        if(idx == word.length()) {
            if(curr.getEnd() == true && change == true) return true;
            return false;
        }
        
        char ch = word.charAt(idx);
        //apna character same hai
        //aage se ans bhi true aa raha hai
        //aage se ans tabhi true aaega jab ek replacement ki hogi
        //and apna character match yaani humne replacement nahi kari
        //this means humne nahi ki but aage kahi ek replacement ho k ans true aa raha hai
        //to ye sahi hai
        //hence return true
        if(curr.contains(ch) == true && search(word,idx + 1,curr.get(ch),change) == true) {
             return true;
        }
        
        if(change == true) return false;
        
        for(char chn ='a';chn<='z';chn++) {
            if(chn == ch) continue;
            //same character ko usi se replace kara doge to galat ans aaega
            
            if(curr.contains(chn) && search(word,idx + 1,curr.get(chn),true)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean search(String searchWord) {
        return search(searchWord,0,root,false);
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
