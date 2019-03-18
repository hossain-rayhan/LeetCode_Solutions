class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfsSearch(graph, 0, path, result);
        return result;
    }
    
    public void dfsSearch(int[][]graph, int node, List<Integer> path, List<List<Integer>> result){
        if(node == graph.length - 1){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for(int nextNode : graph[node]){
            path.add(nextNode);
            dfsSearch(graph, nextNode, path, result);
            path.remove(path.size()-1);
        }
    }
}
