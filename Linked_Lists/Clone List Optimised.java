/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null) return null;
        
        Node org = head;
        while(org != null) {
            Node duplicate = new Node(org.val);
            duplicate.next = org.next;
            org.next = duplicate;
            org = duplicate.next;
        }
        
        org = head;
        while(org != null) {
            Node randomNode = org.random;
            if(org.random != null) randomNode = randomNode.next;
            org.next.random = randomNode;
            org = org.next.next;
        }
        
        org = head;
        Node copyHead = head.next;
        Node tail = copyHead;   
        
        while(org != null) {
            Node duplicate = org.next;
            org.next = duplicate.next;
            if(duplicate.next != null)
            duplicate.next = duplicate.next.next;
            
            org = org.next;
        }
        
        return copyHead;
    }
}
