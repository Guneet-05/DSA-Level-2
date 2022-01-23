  public static class Node {
    int data;
    Node next;
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    void addLast(int val) {
      // Write your code here
      Node node = new Node();
      node.data = val;
      if(head == null) {
          head = tail = node;
      } else {
          tail.next = node;
          tail = node;
      }
      
      size++;
    }
  }
