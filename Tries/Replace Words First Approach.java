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
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie t = new Trie();
        
        for(String word : dictionary) {
            t.insert(word);
        }
        
        List<String> output = new ArrayList<>();
        
        int idx = 0;
        
        while(idx < sentence.length()) {
            String curr = "";
            
            while(idx < sentence.length() && sentence.charAt(idx) != ' ') {
                curr += sentence.charAt(idx);
                idx++;
            }
            
            idx++;
            
            boolean flag = false;
            for(int i=0;i<curr.length();i++) {
                String sub = curr.substring(0,i);
                if(t.search(sub) == true) {
                    output.add(sub);
                    flag = true;
                    break;
                }
            }
            
            if(flag == false) {
                output.add(curr);
            }
        }
        
        String res = "";
        for(int i=0;i<output.size();i++) {
            if(i == output.size() - 1) {
                res += output.get(i);
            } else {
                res += output.get(i) + " ";
            }
            
        }
        
        return res;
    }
}
