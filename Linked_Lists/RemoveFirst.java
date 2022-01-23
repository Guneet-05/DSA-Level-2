  public void removeFirst(){
      // write your code here
      if(head == null) {
          System.out.println("List is empty");
          return;
      }
      
      if(size == 1) head=tail=null;
      
      else head = head.next;
      size--;
    }
