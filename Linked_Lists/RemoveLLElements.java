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
    public ListNode removeElements(ListNode head, int val) {  
        if(head == null) return null;
        
        if(head.next == null && head.val == val) return null;
        
        while(head != null && head.next != null && head.val == val) {
            head = head.next;
        }
        
        if(head.next == null && head.val == val) return null;
        
        ListNode curr = head.next;
        ListNode prev = head;
        
        while(curr != null) {
            if(curr.val == val) {
                prev.next = curr.next;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return head;
    }
}
