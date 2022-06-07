class MaxStack {

    public static class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }

        Node(int val,Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    Node head;
    Node tail;
    TreeMap<Integer,ArrayList<Node>> map;

    public MaxStack() {
        // do intialization if necessary
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        map = new TreeMap<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */    
    public void push(int x) {
        // write your code here
        Node curr = new Node(x,tail.prev,tail);
        tail.prev.next = curr;
        tail.prev = curr;

        //Insert in TreeMap
        if(map.containsKey(x) == false) {
            map.put(x,new ArrayList<>());
        }
        map.get(x).add(curr);
    }

    public int pop() {
        // Delete last ele from DLL
        Node curr = tail.prev;
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        //Delete node from TreeMap
        ArrayList<Node> arr = map.get(curr.val);
        arr.remove(arr.size() - 1);
        if(arr.size() == 0) {
            map.remove(curr.val);
        } else {    
            map.put(curr.val,arr);
        }
        return curr.val;
    }

    /*
     * @return: An integer
     */    
    public int top() {
        return tail.prev.val;
    }

    /*
     * @return: An integer
     */    
    public int peekMax() {
        // write your code here
        return map.lastEntry().getKey();
    }

    /*
     * @return: An integer
     */    
    public int popMax() {
        // write your code here
        int maxVal = peekMax();
        
        ArrayList<Node> arr = map.get(maxVal);
        Node curr = arr.get(arr.size() -1); 

        //delete from DLL
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        //Delete node from TreeMap
        arr.remove(arr.size() - 1);
        if(arr.size() == 0) {
            map.remove(curr.val);
        } else {    
            map.put(curr.val,arr);
        }
        return curr.val;       
    }
}
