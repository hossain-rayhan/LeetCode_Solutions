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
    public int closestValue(TreeNode root, double target) {
        int result = root.val;
        while(root != null){
            if(Math.abs(root.val - target) < Math.abs(result - target)){
                result = root.val;
            }
            //go left or right
            root = root.val > target? root.left : root.right;
        }
        return result;
    }
}
