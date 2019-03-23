//we can use the dfs, here every variable is a node
// a / b = 2.0 means a is a node, b is a node, and there path weight is 2.0

class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for(int i = 0; i < equations.length; i++){
            graph.computeIfAbsent(equations[i][0], n -> new HashMap<>()).put(equations[i][1], values[i]);
            graph.computeIfAbsent(equations[i][1], n -> new HashMap<>()).put(equations[i][0], (1/values[i]));
        }
        double[] result = new double[queries.length];
        for(int i = 0; i < queries.length; i++){
            result[i] = dfs(graph, queries[i][0], queries[i][1], new HashSet<String>(), 1.0);
            if(result[i] == 0.0) result[i] = -1.0;
        }
        
        return result;
    }
    
    public double dfs(HashMap<String, HashMap<String, Double>> graph, String source, String dest, HashSet<String> visited, double value){
        if(!graph.containsKey(source) || visited.contains(source)){
            return 0.0;
        }
        if(source.equals(dest)){
            return value;
        }
        
        visited.add(source);
        double temp = 0.0;
        for(String child: graph.get(source).keySet()){
            temp = dfs(graph, child, dest, visited, graph.get(source).get(child) * value);
            if(temp != 0.0){
                break;
            }
        }
        visited.remove(source);
        return temp;
    }
}
