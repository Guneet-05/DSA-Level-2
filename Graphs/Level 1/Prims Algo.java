import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   static class Pair implements Comparable<Pair>{
       
       int node;
       int parent;
       int wt;
       
       Pair(int node, int parent, int wt) {
           this.node = node;
           this.parent = parent;
           this.wt = wt;
       }
       
       public int compareTo(Pair other) {
           return this.wt - other.wt;
       }
       
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      //prims algo
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      pq.add(new Pair(0,-1,0));
      boolean[] vis = new boolean[vtces];
      
      while(pq.size() > 0) {
          Pair rem = pq.remove();
          
          if(vis[rem.node] == true) continue;
          
          //mark*
          vis[rem.node] = true;
          
          //work
          if(rem.parent != -1) {
              System.out.println("[" + rem.node + "-" + rem.parent + "@" + rem.wt + "]");
          }
          
          //add*
          for(Edge e : graph[rem.node]) {
              if(vis[e.nbr] == false) {
                  pq.add(new Pair(e.nbr,rem.node,e.wt));
              }
          }
      }
   }

}
