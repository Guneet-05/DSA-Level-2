class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] vis = new boolean[graph.length];
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        
        dfs(graph,0,graph.length-1,vis,path,paths);
        return paths;
    }
    
    public void dfs(int[][] graph, int src,int dest,boolean[] vis,List<Integer> path, List<List<Integer>> paths) {
        if(src == dest) {
            List<Integer> copy = new ArrayList<>();
            copy.addAll(path);
            paths.add(copy);
            return;
        }
        
        vis[src] = true;
        
        for(int i=0;i<graph[src].length;i++) {
            if(vis[graph[src][i]] == false) {
                path.add(graph[src][i]);
                dfs(graph,graph[src][i],dest,vis,path,paths);
                path.remove(path.size() - 1);
            }
        }
        
        vis[src] = false;
    }
}
