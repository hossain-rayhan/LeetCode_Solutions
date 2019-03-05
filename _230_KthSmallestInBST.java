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
    public int kthSmallest(TreeNode root, int k) {
        Count countWrapper = new Count(k);
        dfsHelper(root, countWrapper);
        
        return countWrapper.result;
    }
    
    public void dfsHelper(TreeNode root, Count count){
        if(root.left != null){
           dfsHelper(root.left, count);
        }
        count.val = count.val - 1;
        if(count.val == 0){
            count.result = root.val;
            return;
        }
        if(root.right != null){
           dfsHelper(root.right, count);
        }

    }

    class Count{
        int val;
        int result;
        public Count(int val){
            this.val = val;
        }
    }
}
