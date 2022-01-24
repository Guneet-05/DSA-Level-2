 public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null) {
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        
        return prev;
    }

    public static void unfold(ListNode head) {
        ListNode firstHead = new ListNode(-1);
        ListNode secondHead = new ListNode(-1);
        
        ListNode first = firstHead, second  = secondHead;
        
        while(head != null) {
            first.next  = head;
            first = head;
            head = head.next;
            
            if(head != null) {
                second.next = head;
                second = head;
                head = head.next; 
            }
        }
        
        first.next = null;
        second.next = null;
        
        first.next = reverse(secondHead.next);
        head = firstHead.next;
    }
