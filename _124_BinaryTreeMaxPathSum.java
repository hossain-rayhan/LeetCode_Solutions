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
    //root node must be used
    //at most one child can be used 
    //maxSum does not depend on the recursive result
    
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return maxSum;
    }
    
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        
        maxSum = Math.max(maxSum, (left + root.val + right));
        return Math.max(left, right) + root.val;
    }
}
