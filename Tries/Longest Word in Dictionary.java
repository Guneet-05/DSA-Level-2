class Trie {

    public static class Node {
        private Node[] children = new Node[26];
        private boolean isEnd = false;
        
        public boolean contains(char ch) {
            if(children[ch-'a'] == null) return false;
            return true;
        }
        
        public Node get(char ch) {
            return children[ch- 'a'];
        }
        
        public void set(char ch) {
            children[ch-'a'] = new Node();
        }
        
        public boolean getEnd() {
            return isEnd;
        }
        
        public void setEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }
        
    }
    Node root;
    public Trie() {
        root = new Node(); 
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            
            if(curr.contains(ch) == false) {
                curr.set(ch);
            }
            
            curr = curr.get(ch);
        }
        
        curr.setEnd(true);
    }
    
    public boolean search(String word) {
        Node curr = root;
        
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(curr.contains(ch) == false) return false;
            curr = curr.get(ch);
        }
        
        if(curr.isEnd == false) return false;
        return true;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        
        for(int i=0;i<prefix.length();i++) {
            char ch = prefix.charAt(i);
            if(curr.contains(ch) == false) return false;
            curr = curr.get(ch);
        }
        
  
        return true;
    }
}

class Solution {
    
    public String lexicographicallySmaller(String s1, String s2) {
        for(int i=0;i<s1.length();i++) {
            if(s1.charAt(i) < s2.charAt(i)) return s1;
            else if(s2.charAt(i) < s1.charAt(i)) return s2;
        }
        
        return s1;
    }
    
    public String longestWord(String[] words) {
       
        Trie t = new Trie();
        
        for(int i=0;i<words.length;i++) {
            t.insert(words[i]);
        }
        
        String pa = "";
        
        for(String str: words) {
            Trie.Node curr = t.root;
            boolean flag = false;
            
            for(int i=0;i<str.length();i++) {
                char ch = str.charAt(i);
                curr = curr.get(ch);
                
                if(curr == null || curr.getEnd() == false) {
                    flag = true;
                    break;
                }
                
            }
            
            if(flag == false && str.length() == pa.length()) {
                pa = lexicographicallySmaller(pa,str);
            }
            
            if(flag == false && str.length() > pa.length()) {
                pa = str;
            }
            
        }
        
        return pa;
    }
}
