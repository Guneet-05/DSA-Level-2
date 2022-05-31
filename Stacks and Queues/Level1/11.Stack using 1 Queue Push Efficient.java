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
      q.add(val);
    }

    int pop() {
      // write your code here
      if(q.size() == 0) {
          System.out.println("Stack underflow");
          return -1;
      }
      int s = q.size();
      int res = 0;
      while(s > 0) {
          int ele = q.remove();
          s--;
          if(s == 0) {
            res = ele;
            break;
          }
          q.add(ele);
      }
      
      return res;
    }

    int top() {
      // write your code here
      if(q.size() == 0) {
          System.out.println("Stack underflow");
          return -1;
      }
      int s = q.size();
      int res = 0;
      while(s > 0) {
          int ele = q.remove();
          s--;
          if(s == 0) res = ele;
          q.add(ele);
      }
      
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
