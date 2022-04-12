class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        dfs(adj,0,vis,res);
        
        return res;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] vis,ArrayList<Integer> path) {
        vis[src] = true;
        
        for(Integer nbr : graph.get(src)) {
            if(vis[nbr] == false) {
                path.add(nbr);
                dfs(graph,nbr,vis,path);
            }
        }
    }
    
}
