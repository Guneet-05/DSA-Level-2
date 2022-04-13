import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int src;
        int nbr;
        int wt;
        
        Edge(int src, int nbr,int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
        
    }
    
    static class Pair {
        int node;
        int wsf;
        
        Pair(int node, int wsf) {
            this.node = node;
            this.wsf = wsf;
        }
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); //vtces
		int M = scn.nextInt(); //edges
		
		ArrayList<Edge>[] graph = new ArrayList[N+1];
		
		for(int i=0;i<graph.length;i++) {
		    graph[i] = new ArrayList<>();
		}
		
		for(int i=1;i<=M;i++) {
		    int u = scn.nextInt();
		    int v = scn.nextInt();
		    
		    graph[u].add(new Edge(u,v,0)); //edge with cost 0
		    graph[v].add(new Edge(v,u,1)); //reverse edge with cost 1
		}
		
		LinkedList<Pair> q = new LinkedList<>();
		q.add(new Pair(1,0));
		boolean[] vis = new boolean[N + 1];
		while(q.size() > 0) {
		    //remove
		    Pair rem = q.removeFirst();
		    
		    if(rem.node == N) {
		        System.out.println(rem.wsf);
		        return;
		    }
		    
		    if(vis[rem.node] == true) continue;
		    
		    //mark visited
		    vis[rem.node] = true;
		    
		    //work
		    
		    
		    //add
		    for(Edge e : graph[rem.node]) {
		        if(vis[e.nbr] == false) {
		            if(e.wt == 0) {
		                //add at front
		                q.addFirst(new Pair(e.nbr,rem.wsf));
		            } else {
		                //add at rear
		                q.addLast(new Pair(e.nbr,rem.wsf + 1));
		            }
		        }
		    }
		}
		
		System.out.println(-1);
	}
}
