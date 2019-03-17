/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.AbstractMap;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        long max = 0;
        Queue<Map.Entry<TreeNode, Long>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry(root, (long)1));
        
        while(!queue.isEmpty()){
            int size = queue.size();
            long left = queue.peek().getValue();
            long right = left; // In the beginning, left and right are equal
            
            for(int i = 0; i < size; i++){
                Map.Entry<TreeNode, Long> entry = queue.remove();
                TreeNode n = entry.getKey();
                Long counter = entry.getValue();
                
                if(n.left != null){
                    queue.add(new AbstractMap.SimpleEntry(n.left, (2*counter)));
                }
                if(n.right != null){
                    queue.add(new AbstractMap.SimpleEntry(n.right, (2 * counter) + 1));
                }
                
                if(counter > right){
                    right = counter;
                }
            }
            max = Math.max(max, (right-left+1));
        }
        return (int)max;
    }
}
