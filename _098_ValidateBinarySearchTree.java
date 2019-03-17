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
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
    
    public boolean isBST(TreeNode root, TreeNode min, TreeNode max){
        if(root == null){
            return true;
        }
        if(min != null && root.val <= min.val){
            return false;
        }
        if(max != null && root.val >= max.val){
            return false;
        }
        
        return isBST(root.left, min, root) && isBST(root.right, root, max);
    }
}
