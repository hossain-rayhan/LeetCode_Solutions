/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode previous;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }        
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = previous;
        root.left = null;
        previous = root;
    }
    
}
