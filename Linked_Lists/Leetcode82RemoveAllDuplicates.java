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
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        int curr = -200; //invalid val acc to constraints
        
        while(head != null && head.next != null) {
            if(head.val == head.next.val) {
                curr = head.val;
                head = head.next;
            } else if(head.val == curr) {
                head = head.next;
            } else {
                break;
            }
        }
        
        if(head.next == null && head.val == curr) return null;
        
        if(head == null || head.next == null) return head;
        
        curr = -200;
        ListNode p = head.next;
        ListNode prev = head;
        
        while(p.next != null) {
            if(p.val == p.next.val) {
                curr = p.val;
                p.next = p.next.next;
            } else if(p.val == curr) {
                prev.next = p.next;
                p = prev.next;
                curr = -200;
            } else {
                prev = p;
                p = p.next;
            }
        }
        
        if(p.val == curr) prev.next = null;
        
        return head;
        
    }
}
