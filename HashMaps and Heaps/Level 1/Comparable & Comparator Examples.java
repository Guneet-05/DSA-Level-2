import java.io.*;
import java.util.*;

public class Main {
  
  public static class Student implements Comparable<Student>{
      int rollNo;
      int marks;
      int height;
      int weight;
      
      Student() {
          
      }
      
      Student(int rollNo, int marks, int height, int weight) {
          this.rollNo = rollNo;
          this.height = height;
          this.marks = marks;
          this.weight = weight;
      }
      
      public int compareTo(Student other) {
         //Smaller roll No -> Greater Priority
         return this.rollNo - other.rollNo; 
      }
      
      @Override
      public String toString() {
          return ("rollNo = " + this.rollNo + " marks = " + this.marks + " height = " + this.height);
      }
  }
  
//   public static class PriorityQueue {
//     ArrayList<Integer> data;

//     public PriorityQueue() {
//       data = new ArrayList<>();
//     }

//     public void add(int val) {
//       // write your code here
//       data.add(val);
//       upheapify(data.size() - 1);
//     }
    
//     private void upheapify(int i) {
        
//         if(i == 0) {
//             return;
//         }
        
//         int pi = (i-1)/2;
//         if(data.get(i) < data.get(pi)) {
//             swap(i,pi);
//             upheapify(pi);
//         }
//     }
    
//     private void swap(int i, int j) {
//         int ith = data.get(i);
//         int jth  = data.get(j);
//         data.set(i,jth);
//         data.set(j,ith);
//     }

//     public int remove() {
//       // write your code here
//       if(this.size() == 0) {
//           System.out.println("Underflow");
//           return -1;
//       }
      
//       swap(0,data.size() - 1);
//       int val = data.remove(data.size() - 1);
//       downheapify(0);
//       return val;
//     }
    
//     private void downheapify(int pi) {
        
//         int mini = pi;
        
//         int li = 2*pi + 1;
//         if(li < data.size() && data.get(li) < data.get(mini)) {
//             mini = li;
//         }
        
//         int ri = 2*pi + 2;
//         if(ri < data.size() && data.get(ri) < data.get(mini)) {
//             mini = ri;
//         }
        
//         if(mini != pi) {
//             swap(pi,mini);
//             downheapify(mini);
//         }
//     }

//     public int peek() {
//       // write your code here
//       if(this.size() == 0) {
//           System.out.println("Underflow");
//           return -1;
//       }
      
//       return data.get(0);
//     }

//     public int size() {
//       // write your code here
//       return data.size();
//     }
//   }

    public static class StudentComparator implements Comparator<Student> {
        public int compare(Student s, Student other) {
            //Greater the marks-> Greater the priority
            return other.marks - s.marks;
        }
    } 

  public static void main(String[] args) throws Exception {
   
      PriorityQueue<Student> q = new PriorityQueue<>(new StudentComparator());
      q.add(new Student(30,91,100,70));
      q.add(new Student(40,90,101,71));
      q.add(new Student(50,100,102,72));
      q.add(new Student(60,89,103,73));
      
      while(q.size() > 0) {
          Student top = q.remove();
          System.out.println(top);
      }
     
      
  }
  
}
