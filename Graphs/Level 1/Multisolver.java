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
    
    // public static void printAllPaths(ArrayList<Edge>[] graph,int src, int dest, boolean[] vis) {
    //     dfs(graph,src,dest,vis,"" + src);
    // }
    
    static String smallestPath = "";
    static String largestPath = "";
    static int smallestPathWt = Integer.MAX_VALUE;
    static int largestPathWt = Integer.MIN_VALUE;
    static String floorPath = "";
    static int floorWt = Integer.MIN_VALUE;
    static String ceilPath = "";
    static int ceilWt = Integer.MAX_VALUE;
    static int val = 0;
    static int k = 0;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    
    static class Pair implements Comparable<Pair>{
        String psf;
        int wsf;
        
        Pair(String psf, int wsf) {
            this.psf = psf;
            this.wsf = wsf;
        }
        
        public int compareTo(Pair other) {
            return this.wsf - other.wsf;
        }
    }
    
    public static void dfs(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis,String psf,int wsf) {
        if(src == dest) {
            
            //smallest
            if(wsf < smallestPathWt) {
                smallestPath = psf;
                smallestPathWt = wsf;
            }
            
            //largest
            if(wsf > largestPathWt) {
                largestPath = psf;
                largestPathWt = wsf;
            }
            
            //floor
            if(wsf < val && wsf > floorWt) {
                floorWt = wsf;
                floorPath = psf;
            }
            
            //ceil
            if(wsf > val && wsf < ceilWt) {
                ceilWt = wsf;
                ceilPath = psf;
            }
            
            //kth largest
            if(pq.size() < k) {
                pq.add(new Pair(psf,wsf));
            } else if(wsf > pq.peek().wsf) {
                pq.remove();
                pq.add(new Pair(psf,wsf));
            }
            
            return;
        }
        
        vis[src] = true;
        
        for(Edge e : graph[src]) {
            if(vis[e.nbr] == false) {
                dfs(graph,e.nbr,dest,vis,psf + e.nbr,wsf + e.wt);
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
        val = scn.nextInt();
        k = scn.nextInt();
        
        boolean[] vis = new boolean[vtces];
        dfs(graph,src,dest,vis,"" + src,0);
        
        System.out.println("Smallest Path = " + smallestPath + "@" + smallestPathWt);
        System.out.println("Largest Path = " + largestPath + "@" + largestPathWt);
        System.out.println("Just Larger Path than " + val + " = " + ceilPath + "@" + ceilWt);
        System.out.println("Just Smaller Path than " + val + " = " + floorPath + "@" + floorWt);
        System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
    }
}
