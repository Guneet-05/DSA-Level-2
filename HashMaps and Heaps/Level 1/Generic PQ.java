import java.io.*;
import java.util.*;

public class Main {

  public static class Student implements Comparable<Student> {
    int marks;
    int rollNo;
    int weight;
    int height;
    
    Student() {
        
    }
    
      @Override
      public String toString() {
          return ("rollNo = " + this.rollNo + " marks = " + this.marks + " height = " + this.height);
      }
    
    Student(int marks,int weight, int rollNo, int height) {
        this.marks = marks;
        this.weight = weight;
        this.height = height;
        this.rollNo = rollNo;
    }
    
    public int compareTo(Student other) {
        return other.marks - this.marks;
    }
  }
  
  public static class StudentRollNoComparator implements Comparator<Student> {
      
      public int compare(Student me, Student other) {
          return me.rollNo - other.rollNo;
      }
  }
  
 public static class PriorityQueue<K> {
    ArrayList<K> data;
    private int size;
    private Comparator<K> comp;

    public PriorityQueue() {
      data = new ArrayList<>();
      size = 0;
      comp = null;
    }
    
    public PriorityQueue(Comparator<K> comp) {
        this.comp = comp;
        data = new ArrayList<>();
        size = 0;
    }
    
    // O(n) time for inserting N Elements
    public PriorityQueue(K[] arr) {
        data = new ArrayList<>();
        
        for(K val : arr) {
            data.add(val);
            size++;
        }
        
        for(int i=(size()-1)/2;i>=0;i--) {
            downheapify(i);
        }
    }

    public void add(K val) {
      // write your code here
      data.add(val);
      size++;
      upheapify(size() - 1);
    }
    
    private boolean isSmaller(int i1,int i2) {
        K obj1 = data.get(i1);
        K obj2 = data.get(i2);
        
        if(comp == null) {
            Comparable obj1C = (Comparable)obj1;
            Comparable obj2C = (Comparable)obj2;
            
            if(obj1C.compareTo(obj2C) < 0) {
                return true;
            }
            
            return false;
        } else {
            if(comp.compare(obj1,obj2) < 0) return true;
            else return false;
        }
    }
    
    private void upheapify(int i) {
        
        if(i == 0) {
            return;
        }
        
        int pi = (i-1)/2;
        if(isSmaller(i,pi)) {
            swap(i,pi);
            upheapify(pi);
        }
    }
    
    private void swap(int i, int j) {
        K ith = data.get(i);
        K jth  = data.get(j);
        data.set(i,jth);
        data.set(j,ith);
    }

    public K remove() {
      // write your code here
      if(this.size() == 0) {
          System.out.println("Underflow");
          return null;
      }
      
      swap(0,size() - 1);
      K val = data.get(size - 1);
      size--;
      downheapify(0);
      return val;
    }
    
    private void downheapify(int pi) {
        
        int mini = pi;
        
        int li = 2*pi + 1;
        if(li < size && isSmaller(li,mini) == true) {
            mini = li;
        }
        
        int ri = 2*pi + 2;
        if(ri < size && isSmaller(ri,mini) == true) {
            mini = ri;
        }
        
        if(mini != pi) {
            swap(pi,mini);
            downheapify(mini);
        }
    }

    public K peek() {
      // write your code here
      if(this.size() == 0) {
          System.out.println("Underflow");
          return null;
      }
      
      return data.get(0);
    }

    public int size() {
      // write your code here
      return size;
    }
    
    public ArrayList<K> heapSort() {
        ArrayList<K> sorted = new ArrayList<>();
        
        while(this.size() > 0) {
            sorted.add(this.remove());
        }
        
        return sorted;
    }
    
    public ArrayList<K> inPlaceHeapSort() {
        while(size() > 0) {
            remove();
        }
        
        return data;
    }
  }

  public static void main(String[] args) throws Exception {
    PriorityQueue<Student> pq = new PriorityQueue<>(new StudentRollNoComparator());
    
    pq.add(new Student(80,75,2,103));
    pq.add(new Student(70,70,1,150));
    pq.add(new Student(20,60,8,120));
    pq.add(new Student(90,90,4,115));
    
    while(pq.size() > 0) {
        Student top = pq.remove();
        System.out.println(top);
    }
  }
}
