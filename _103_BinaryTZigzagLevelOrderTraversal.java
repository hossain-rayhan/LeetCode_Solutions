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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                TreeNode n = queue.remove();
                temp.add(n.val);
                if(n.left != null) queue.offer(n.left);
                if(n.right != null) queue.offer(n.right);
            }
            if(!leftToRight){
                Collections.reverse(temp);
            }
            result.add(temp);
            
            leftToRight = leftToRight? false : true;
        }
        
        return result;
    }
}
