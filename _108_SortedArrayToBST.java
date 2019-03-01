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
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBST(nums, 0, nums.length - 1);
    }
    
    public TreeNode arrayToBST(int[]nums, int start, int end){
        TreeNode node = null;
        if(start > end){
            return node;
        }
        int mid = (start + end)/ 2;
        node = new TreeNode(nums[mid]);
        
        node.left = arrayToBST(nums, start, mid-1);
        node.right = arrayToBST(nums, mid+1, end);
        
        return node;
    }
}
