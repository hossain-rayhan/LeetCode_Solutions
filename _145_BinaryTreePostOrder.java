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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //postorder(root, result);
        iterativePostOrder(root, result);
        return result;
    }
    
    //iterative solution- a little bit tricky
    public void iterativePostOrder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode n = stack.pop();
            result.add(n.val);
            if(n.left != null) stack.push(n.left);
            if(n.right != null) stack.push(n.right);
        }
        Collections.reverse(result);
    }
    
    //recursive solution- which is easy
    public void postorder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }    
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }
}
