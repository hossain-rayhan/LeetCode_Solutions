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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        usingBFS(root, list);
        return list;
    }
    
    public void usingBFS(TreeNode root,  List<List<Integer>> list){
        if(root == null){
            return;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> levelList = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.remove();
                levelList.add(node.val);
                
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            list.add(levelList);
        }
    }
}
