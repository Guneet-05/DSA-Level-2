import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;
    private int size;

    public PriorityQueue() {
      data = new ArrayList<>();
      size = 0;
    }
    
    // O(n) time for inserting N Elements
    public PriorityQueue(int[] arr) {
        data = new ArrayList<>();
        
        for(int val : arr) {
            data.add(val);
            size++;
        }
        
        for(int i=(size()-1)/2;i>=0;i--) {
            downheapify(i);
        }
    }

    public void add(int val) {
      // write your code here
      data.add(val);
      size++;
      upheapify(size() - 1);
    }
    
    private void upheapify(int i) {
        
        if(i == 0) {
            return;
        }
        
        int pi = (i-1)/2;
        if(data.get(i) < data.get(pi)) {
            swap(i,pi);
            upheapify(pi);
        }
    }
    
    private void swap(int i, int j) {
        int ith = data.get(i);
        int jth  = data.get(j);
        data.set(i,jth);
        data.set(j,ith);
    }

    public int remove() {
      // write your code here
      if(this.size() == 0) {
          System.out.println("Underflow");
          return -1;
      }
      
      swap(0,size() - 1);
      int val = data.get(size - 1);
      size--;
      downheapify(0);
      return val;
    }
    
    private void downheapify(int pi) {
        
        int mini = pi;
        
        int li = 2*pi + 1;
        if(li < size && data.get(li) < data.get(mini)) {
            mini = li;
        }
        
        int ri = 2*pi + 2;
        if(ri < size && data.get(ri) < data.get(mini)) {
            mini = ri;
        }
        
        if(mini != pi) {
            swap(pi,mini);
            downheapify(mini);
        }
    }

    public int peek() {
      // write your code here
      if(this.size() == 0) {
          System.out.println("Underflow");
          return -1;
      }
      
      return data.get(0);
    }

    public int size() {
      // write your code here
      return size;
    }
    
    public ArrayList<Integer> heapSort() {
        ArrayList<Integer> sorted = new ArrayList<>();
        
        while(this.size() > 0) {
            sorted.add(this.remove());
        }
        
        return sorted;
    }
    
    public ArrayList<Integer> inPlaceHeapSort() {
        while(size() > 0) {
            remove();
        }
        
        return data;
    }
  }

  public static void main(String[] args) throws Exception {
     int[] arr = {20,50,30,10,40,60};
     PriorityQueue pq = new PriorityQueue(arr);
     System.out.println(pq.heapSort());
  }
}
