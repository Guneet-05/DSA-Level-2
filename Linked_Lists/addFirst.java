  public void addFirst(int val) {
      // write your code here
      Node node = new Node();
      node.data = val;
      
      if(head == null) {
          head = tail = node;
      } else {
          node.next =head;
          head = node;
      }
      
      size++;
    }
