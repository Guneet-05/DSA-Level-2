import java.io.*;
import java.util.*;

public class Main {
   
   public static class Edge {
       int src;
       int nbr;
       
       Edge(int src, int nbr) {
           this.src = src;
           this.nbr = nbr;
       }
   }

   public static void dfs(ArrayList<Edge>[] graph, int src,ArrayList<Integer> comp, boolean[] vis) {
       vis[src] = true;
       comp.add(src);
       
       for(Edge e : graph[src]) {
           if(vis[e.nbr] == false) {
               dfs(graph,e.nbr,comp,vis);
           }
       }
   }

   public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt(); //no of vertices
      int k  = scn.nextInt(); //no of edges
      
      ArrayList<Edge>[] graph = new ArrayList[n];
      for(int i=0;i<n;i++) {
          graph[i] = new ArrayList<>();
      }
      
      for(int i=0;i<k;i++) {
          int src= scn.nextInt();
          int nbr = scn.nextInt();
          
          graph[src].add(new Edge(src,nbr));
          graph[nbr].add(new Edge(nbr,src));
      }
      
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean[] vis = new boolean[n];
      
      for(int i=0;i<vis.length;i++) {
          if(vis[i] == false) {
              ArrayList<Integer> comp = new ArrayList<>();
              dfs(graph,i,comp,vis);
              comps.add(comp);
          }
      }
      
      int res = 0;
      
      for(int i=0;i<comps.size();i++) {
          int remSize = 0;
          for(int j=i+1;j<comps.size();j++) {
              remSize += comps.get(j).size();
          }
          res += comps.get(i).size() * remSize;
      }
      
      System.out.println(res);
   }

}
