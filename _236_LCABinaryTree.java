/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
//https://www.youtube.com/watch?v=F-_1sbnPbWQ

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root == null)
            return null;
        
        if(root == p || root == q){
            return root;
        }
        
        TreeNode left_lca = lowestCommonAncestor(root.left, p, q);
        TreeNode right_lca = lowestCommonAncestor(root.right, p, q);
        
        //if both left and right subtree returns non-null, then the root is lca
        if(left_lca != null && right_lca != null){
            return root;
        }
        
        // Otherwise check if left subtree or right subtree is LCA 
        return (left_lca != null) ? left_lca : right_lca;
    }
}
