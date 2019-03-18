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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper (preorder, inorder, 0, 0, inorder.length - 1);
    }
    
    public TreeNode helper(int[] pre, int[] in, int preStart, int inStart, int inEnd){
        if(preStart >= pre.length || inStart > inEnd){
            return null;
        }
        
        TreeNode root = new TreeNode(pre[preStart]);
        
        //find the root index from inorder array
        int rootIndex = inStart;
        while(in[rootIndex] != root.val){
            rootIndex++;
        }
        
        //populate the left and right child
        root.left = helper(pre, in, preStart+1, inStart, rootIndex-1);
        root.right = helper(pre, in, preStart + rootIndex - inStart + 1, rootIndex+1, inEnd);
        
        return root;
    }
}
