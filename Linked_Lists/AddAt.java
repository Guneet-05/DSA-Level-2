 public void addAt(int idx, int val){
      // write your code here
      if(idx == 0) {
          addFirst(val);
          return;
      } 
      
      if(idx == size)  {
          addLast(val);
          return;
      }
      
      if(idx < 0 || idx > size) {
          System.out.println("Invalid arguments");
          return;
      }
      
      Node curr = head;
      for(int i=1;i<idx;i++) {
          curr = curr.next;
      }
      
      Node temp = new Node();
      temp.data = val;
      temp.next = curr.next;
      curr.next = temp;
      size++;
    }
