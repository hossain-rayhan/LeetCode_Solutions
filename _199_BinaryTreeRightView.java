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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        rightViewOfBinaryTree(root, list, 0);
        return list;
    }
    
    public void rightViewOfBinaryTree(TreeNode root, ArrayList<Integer> list, int depth){
        if(root == null){
            return;
        }
        //on every depth one node shoud be added
        if(list.size() == depth){
            list.add(root.val);
        }
        
        //first explore the right, then left
        rightViewOfBinaryTree(root.right, list, depth + 1);
        rightViewOfBinaryTree(root.left, list, depth + 1);
    }
}
