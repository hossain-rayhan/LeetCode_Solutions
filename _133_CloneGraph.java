/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        
        HashMap<Node, Node> map = new HashMap<>();
        dfs(map, node);
        
        return map.get(node);
    }
    
    public void dfs(HashMap<Node, Node> map, Node root){
        if(map.containsKey(root)){
            return;
        }
        Node clone = new Node(root.val, new ArrayList<Node>());
        map.put(root, clone);
        for(Node nbr: root.neighbors){
            dfs(map, nbr);
            map.get(root).neighbors.add(map.get(nbr));
        }
    }
}
