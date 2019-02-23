/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return inOrderTraversal(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        
        //System.out.println(Arrays.toString(nodes));
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("index", 0);
        return buildTree(nodes, map);
    }
    
    public String inOrderTraversal(TreeNode root){
        if(root == null){
            return "null";
        }else{
            int v = root.val;
            String left = inOrderTraversal(root.left);
            String right = inOrderTraversal(root.right);
            
            return v + "," + left+ "," + right;
        }
    }
    
    //in recursive function, we cannot keep a global counter
    //the solution is to maintain a key, value pair
    public TreeNode buildTree(String[] nodes, HashMap<String, Integer> map){
        int i = map.get("index");
        if(nodes[i].equals("null")){
            map.put("index", (i+1));
            return null;
        }else{
            TreeNode n = new TreeNode(Integer.parseInt(nodes[i]));
            map.put("index", (i+1));
            n.left = null;
            n.right = null;
            TreeNode l = buildTree(nodes, map);
            TreeNode r = buildTree(nodes, map);
            n.left = l;
            n.right = r;
        
            return n;
        }
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
