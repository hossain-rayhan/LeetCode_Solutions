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
        return buildTree(nodes, 0);
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
    
    public TreeNode buildTree(String[] nodes, int index){
        if(nodes[index].equals("null")){
            return null;
        }else{
            TreeNode n = new TreeNode(Integer.parseInt(nodes[index]));
            TreeNode l = buildTree(nodes, index + 1);
            TreeNode r = buildTree(nodes, index + 1);
            n.left = l;
            n.right = r;
        
            return n;
        }
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
