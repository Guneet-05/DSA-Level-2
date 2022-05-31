import java.io.*;
import java.util.*;

public class Main {

  public static class QueueToStackAdapter {
    Queue<Integer> q;

    public QueueToStackAdapter() {
      q = new ArrayDeque<>();
    }

    int size() {
      // write your code here
      return q.size();
    }

    void push(int val) {
      // write your code here
      int s = q.size();
      
      if(q.size() == 0) {
          q.add(val);
          return;
      }
      
      for(int i=1;i<=s;i++) {
          int ele = q.remove();
          if(i == 1) {
              q.add(val);
          }
          q.add(ele);
      }
    }

    int pop() {
      // write your code here
      if(q.size() == 0) {
          System.out.println("Stack underflow");
          return -1;
      }
      
      return q.remove();
    }

    int top() {
      // write your code here
      if(q.size() == 0) {
          System.out.println("Stack underflow");
          return -1;
      }
      
      return q.peek();
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
