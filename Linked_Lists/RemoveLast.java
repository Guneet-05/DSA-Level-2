 public void removeLast(){
      // write your code here
      if(size == 0) {
          System.out.println("List is empty");
          size--;
          return;
      }
      
      if(size == 1) {
          head = tail = null;
          size--;
          return;
      }
      
      Node curr = head;
      for(int i=0;i<size-2;i++) {
          curr = curr.next;
      }
      
      curr.next = null;
      tail = curr;
      
      size--;
    }
