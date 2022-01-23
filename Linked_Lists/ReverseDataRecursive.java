 public Node reverseDR(Node left, Node right,int count) {
        if(left == null) {
            return right;
        }

        reverseDR(left.next,right,count + 1);
        if(count < size/2) {
            swap(left, right);
        }
        right = right.next;

        return right;
    }

    public void reverseDR() {
       Node left = head;
       Node right = head;
       reverseDR(left, right,0);
    }
