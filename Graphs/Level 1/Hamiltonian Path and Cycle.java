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
   
   public static boolean isEdge(ArrayList<Edge>[] graph, int osrc,int src) {
       
       for(Edge e : graph[osrc]) {
           if(e.nbr == src) {
               return true;
           }
       }
       
       return false;
   }
   
   public static void dfs(ArrayList<Edge>[] graph, int src,String psf,HashSet<Integer> vis,int osrc) {
       
       if(vis.size() == graph.length - 1) {
           if(isEdge(graph,osrc,src) == true) {
               System.out.println(psf + "*");
           } else {
               System.out.println(psf + ".");
           }
           return;
       }
       
       vis.add(src);
       
       for(Edge e : graph[src]) {
           if(vis.contains(e.nbr) == false) {
               dfs(graph,e.nbr,psf + e.nbr,vis,osrc);
           }
       }
       
       vis.remove(src);
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

      int src = Integer.parseInt(br.readLine());

      // write all your codes here
      dfs(graph,src,"" + src,new HashSet<>(),src);
   }


}
