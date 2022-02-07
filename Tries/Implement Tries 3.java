public class Trie {
    
    public static class Node {
        private int isEnd = 0;
        private int prefixCount = 0;
        private Node[] children = new Node[26];
        
        public boolean contains(char ch) {
            if(children[ch-'a'] == null) return false;
            return true;
        }
        
        public Node get(char ch) {
            return children[ch-'a'];
        }
        
        public void set(char ch) {
            children[ch-'a'] = new Node();
        }
        
        public int getEndFreq() {
            return isEnd;
        }
        
        public int getPrefCount() {
            return prefixCount;
        }
        
        public void increaseEndFreq() {
            isEnd++;
        }
        
        public void decreaseEndFreq() {
            isEnd--;
        }
        
        public void increasePrefCount() {
            prefixCount++;
        }
        
        public void decreasePrefCount() {
            prefixCount--;
        }
        
    }
    
    Node root;
    
    public Trie() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node curr = root;
        for(int i=0;i<word.length();i++) {
            curr.increasePrefCount();
            char ch = word.charAt(i);
            if(curr.contains(ch) == false) {
                curr.set(ch);
            }
            
            curr = curr.get(ch);
        }
        curr.increasePrefCount();
        curr.increaseEndFreq();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(curr.contains(ch) == false) {
                return 0;
            }
            
            curr = curr.get(ch);
        }
//         curr.increasePrefCount();
        
        return curr.getEndFreq();
    }

    public int countWordsStartingWith(String word) {
        // Write your code here
        Node curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(curr.contains(ch) == false) {
                return 0;
            }
            curr = curr.get(ch);
        }
        
        return curr.getPrefCount();
    }

    public void erase(String word) {
        // Write your code here.
        
        if(countWordsEqualTo(word) <= 0) {
            return;
        }
        
         Node curr = root;
        for(int i=0;i<word.length();i++) {
            curr.decreasePrefCount();
            char ch = word.charAt(i); 
            curr = curr.get(ch);
        }
        curr.decreasePrefCount();
        curr.decreaseEndFreq();
    }

}
