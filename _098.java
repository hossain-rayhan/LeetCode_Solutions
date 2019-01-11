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
        return checkBST(root, -21474836489L, 21474836479L);
    }
    
    public boolean checkBST(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        if((long)root.val <= min || (long)root.val >= max){
            return false;
        }
        
        return checkBST(root.left, min, (long)root.val) & checkBST(root.right, (long)root.val, max);
    }
}
