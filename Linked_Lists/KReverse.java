public void kReverse(int k) {
      // write your code here
      LinkedList prev = new LinkedList();
      
      while(size > 0) {
          LinkedList curr = new LinkedList();
          
          if(size < k) {
              while(size > 0) {
                  int val = head.data;
                  this.removeFirst();
                  curr.addLast(val);
              }
          } 
          else {
            for(int i=0;i<k;i++) {
                int val = head.data;
                this.removeFirst();
                curr.addFirst(val);
            }  
          }
          
          if(prev.head == null) {
              prev = curr;
          } else {
              prev.tail.next = curr.head;
              prev.tail = curr.tail;
              prev.size += curr.size;
          }
      }
      
      prev.tail.next = null;
      this.head = prev.head;
      this.tail = prev.tail;
      this.size = prev.size;
      
    }
