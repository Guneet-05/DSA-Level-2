import java.io.*;
import java.util.*;

public class Main {

  public static class QueueToStackAdapter {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter() {
      mainQ = new ArrayDeque<>();
      helperQ = new ArrayDeque<>();
    }

    int size() {
      // write your code here
      return mainQ.size();
    }

    void push(int val) {
      // write your code here
      mainQ.add(val);
    }

    int pop() {
      // write your code here
      
      if(mainQ.size() == 0) {
          System.out.println("Queue underflow");
          return -1;
      }
      
      int res = -1;
      while(mainQ.size() > 0) {
          int ele = mainQ.remove();
          if(mainQ.size() == 0) {
              res = ele;
              break;
          }
          helperQ.add(ele);
      }
      
      mainQ = helperQ;
      helperQ = new ArrayDeque<>();
      return res;
    }

    int top() {
      // write your code here
       if(mainQ.size() == 0) {
          System.out.println("Queue underflow");
          return -1;
      }
      
      int res = -1;
      while(mainQ.size() > 0) {
          int ele = mainQ.remove();
          if(mainQ.size() == 0) {
              res = ele;
          }
          helperQ.add(ele);
      }
      
      mainQ = helperQ;
      helperQ = new ArrayDeque<>();
      return res;
      
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    QueueToStackAdapter st = new QueueToStackAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      }
      str = br.readLine();
    }
  }
}
