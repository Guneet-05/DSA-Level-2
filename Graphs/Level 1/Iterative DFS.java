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
   
   public static class Pair
   {
       int node;
       String psf;
       
       Pair(int node,String psf)
       {
           this.node = node;
           this.psf=psf;
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      // write your code here  
      boolean[] vis=new boolean[vtces];
      Stack<Pair> st=new Stack<>();
      st.push(new Pair(src,src + ""));
      
      while(st.size() > 0) {
        Pair rem = st.pop();
        
        if(vis[rem.node] == true) continue;
        
        vis[rem.node] = true;
        
        System.out.println(rem.node + "@" + rem.psf);
        
        for(Edge e : graph[rem.node]) {
            if(vis[e.nbr] == false) {
                st.push(new Pair(e.nbr,rem.psf + e.nbr));
            }
        }
      }
      
      
   }
   
}
