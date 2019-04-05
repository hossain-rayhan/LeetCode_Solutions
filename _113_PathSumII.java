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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        dfs(root, 0, sum, result, new ArrayList<Integer>());
        return result;
    }
    
    public void dfs(TreeNode root, int currentSum, int target, List<List<Integer>> result, List<Integer> path){
        if(root == null){
            return;
        }
        currentSum = currentSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null && currentSum == target){
            result.add(new ArrayList<>(path));
            path.remove(path.size()-1); //remove the last added node
            return;
        }
        
        dfs(root.left, currentSum, target, result, path);
        dfs(root.right, currentSum, target, result, path);
        if(path.size() > 0){
            path.remove(path.size()-1); //remove the last added node
        }
    }
}
