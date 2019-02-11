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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if(root == null)
            return newNode;
        
        TreeNode start = root;
        insertInBST(root, newNode);
        return start;
    }
    public void insertInBST(TreeNode current, TreeNode newNode){
        if(newNode.val < current.val){
            if(current.left == null){
                current.left = newNode;
            }else{
                insertInBST(current.left, newNode);
            }
        }else{
            if(current.right == null){
                current.right = newNode;
            }else{
                insertInBST(current.right, newNode);
            }
        }
    }
}
