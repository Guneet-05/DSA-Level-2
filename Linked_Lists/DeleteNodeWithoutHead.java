/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr = node; 
        ListNode ahead = node.next;
        
        while(ahead.next != null) {
            curr.val = ahead.val;
            curr = ahead;
            ahead = ahead.next;
        }
        curr.val = ahead.val;
        curr.next = null;
    }
}
