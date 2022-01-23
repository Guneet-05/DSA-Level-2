 public void removeAt(int index) {
      // write your code here
       if(index < 0 || index >= size) {
            System.out.println("Invalid arguments");
            return;
        }
        
        if(size == 0) {
            System.out.println("List is empty");
            return;
        }
        
        if(index == 0) {
            removeFirst();
            return;
        }
        
        if(index == size - 1) {
            removeLast();
            return;
        }
        
        Node curr = head;
        for(int i=1;i<index;i++) {
            curr = curr.next;
        }
        
        curr.next = curr.next.next;
        size--;
    }
