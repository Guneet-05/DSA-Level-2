public class Solution {
    
    public static class Node {
       Node[] children = new Node[26];
       int prefCount = 0;
       int isEnd = 0;

       Node get(char ch) {
           return children[ch-'a'];
       }

       void set(char ch) {
           children[ch-'a'] = new Node();
       }

       boolean contains(char ch) {
           if(children[ch-'a'] != null) return true;
           return false;
       }
    }

    public void insert(Node root, String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(curr.contains(ch) == false) {
                curr.set(ch);
            }
            curr.prefCount++;
            curr = curr.get(ch);
        }

        curr.prefCount++;
        root.isEnd++;
    }

    public String search(Node root, String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            
            if(curr.prefCount == 1) return word.substring(0,i);
            curr = curr.get(ch);
        }

        return word;
    }

    public String[] prefix(String[] A) {
       Node root = new Node();
       for(String str : A) {
           insert(root,str);
       }   

       String[] res = new String[A.length];
       for(int i=0;i<res.length;i++) {
           res[i] = search(root,A[i]);
       }

       return res;
    }

}
