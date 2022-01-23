 public void reversePI(){
      // write your code here
      if(size == 0 || size == 1) {
          return;
      }
      Node prev = null;
      Node curr = head;
      
      while(curr != null) {
          Node ahead = curr.next;
          curr.next = prev;
          prev = curr;
          curr = ahead;
      }
      
    //   swap head and tail
      Node temp = head;
      head = tail;
      tail = temp;
    }
