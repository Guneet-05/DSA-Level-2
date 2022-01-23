 public void reverseDI() {
      // write your code here
      int left = 0;
      int right = size - 1;
      
      while(left <= right) {
          Node leftNode = getNodeAt(left);
          Node rightNode = getNodeAt(right);
          int temp = leftNode.data;
          leftNode.data = rightNode.data;
          rightNode.data = temp;
          left++;
          right--;
      }
    }
