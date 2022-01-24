 private Node getMiddle(Node head) {
        
        if(head == null || head.next == null) return head;
        
        Node slow = head;
        Node fast = head;
        Node prev = null;
        
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast == null) //even case
           return prev;
           
        return slow;
    }
    
    public Node insertInMid(Node head, int data){
        //Insert code here, return the head of modified linked list
        Node mid = getMiddle(head);
        Node temp = new Node(data);
        temp.next = mid.next;
        mid.next = temp;
        
        return head;
    }
