/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast .next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
     public ListNode reverseList(ListNode head) {
        
        ListNode p = head;
        ListNode q = null;
        ListNode r = null;
        
        while(p != null) {
            r=q;
            q=p;
            p=p.next;
            
            q.next = r;
        }
        
        return q;
    }

    
    public void reorderList(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode second = reverseList(mid.next);
        mid.next = null;
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while(head != null || second!=null) {
            if(head != null) {
                tail.next = head;
                tail = head;
                head = head.next;
            }
            if(second != null) {
                tail.next = second;
                tail = second;
                second = second.next;
            }
            
        }
        
        tail.next = null;
        head = dummy.next;
        
    }
    
    
}
