  private void reversePRHelper(Node node){
      // write your code here
      
      if(head == null || head.next == null) {
          return;
      }
      
      reversePRHelper(node.next);
      
      //khud pe khade hoke apne next ka kaam karao
      node.next.next = node;
    }   

    public void reversePR(){
      // write your code here
      reversePRHelper(head);
      
      //swap head and tail
      Node temp = head;
      head = tail;
      tail = temp;
      
      //set tail's next to null
      tail.next = null;
    }
