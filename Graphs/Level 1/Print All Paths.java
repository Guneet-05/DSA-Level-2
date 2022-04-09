import java.util.*;
import java.io.*;

public class Main {
    
    public static class Edge {
        int src;
        int nbr;
        int wt;
        
        Edge(int src, int nbr) {
            // for unweighted graph
            this.src = src;
            this.nbr = nbr;
        }
        
        Edge(int src,int nbr, int wt) {
            // for weighted graph
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    
    public static void displayGraph(ArrayList<Edge>[] graph) {
        int vtces = graph.length;
        
        for(int i=0;i<vtces;i++) {
            System.out.print(i + " -> ");
            System.out.print("[");
            for(Edge e : graph[i]) {
                System.out.print("{" + e.src + "," + e.nbr + "," + e.wt + "},");
            }
            System.out.println("]");
        }
    }
    
    public static void printAllPaths(ArrayList<Edge>[] graph,int src, int dest, boolean[] vis) {
        dfs(graph,src,dest,vis,"" + src);
    }
    
    public static void dfs(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis,String psf) {
        if(src == dest) {
            System.out.println(psf);
        }
        
        vis[src] = true;
        
        for(Edge e : graph[src]) {
            if(vis[e.nbr] == false) {
                dfs(graph,e.nbr,dest,vis,psf + e.nbr);
            }
        }
        
        vis[src] = false; //backtracking 
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        
        for(int i=0;i<vtces;i++) {
            graph[i] = new ArrayList<>();
        }
        
        int edges = scn.nextInt();
        
        while(edges-- > 0) {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = scn.nextInt();
            
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }
        
        int src = scn.nextInt();
        int dest = scn.nextInt();
        // displayGraph(graph);
        boolean[] vis = new boolean[vtces];
        printAllPaths(graph,src,dest,vis);
    }
}
