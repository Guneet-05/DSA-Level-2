import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   
   static class Pair {
       int node;
       String psf;
       
       Pair(int node, String psf) {
           this.node = node;
           this.psf = psf;
       }
   }
   
   public static boolean bfs(ArrayList<Edge>[] graph,int src) {
      Queue<Pair> q = new ArrayDeque<>();
      boolean[] vis = new boolean[graph.length];
      q.add(new Pair(src,"" + src));
      
      while(q.size() > 0) {
          Pair front = q.remove(); 
          
          if(vis[front.node] == true) {
              return true;
          }
          
          vis[front.node] = true;
          
          for(Edge e : graph[front.node]) {
              if(vis[e.nbr] == false) {
                  q.add(new Pair(e.nbr,front.psf + e.nbr));
              }
          }
      }
      return false;
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      // write your code here
      boolean[] vis = new boolean[vtces];
      
      for(int i=0;i<vtces;i++) {
          if(vis[i] == false) {
              boolean isCyclic = bfs(graph,i);
              if(isCyclic) {
                  System.out.println(true);
                  return;
              }
          }
      }
      
      System.out.println(false);
   }
}
