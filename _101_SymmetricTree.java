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
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    
    public boolean helper(TreeNode left, TreeNode right){
        if(left == null){
            return right == null;
        }else if(right == null){
            return false;
        }else if(left.val == right.val){
            return helper(left.left, right.right) && helper(left.right, right.left);
        }else{
            return false;
        }
    }
}
