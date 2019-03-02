//https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        return bottomUpDP(nums);
        
        /**int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = nums[0];
        return topDownDP(nums, nums.length, memo);**/
    }
    
    //top-down + memoization
    public int topDownDP(int[] nums, int i, int[] memo){
        if(i <= 0){
            return 0;
        }
        
        if(memo[i] < 0){
            memo[i] = Math.max(nums[i-1] + topDownDP(nums, i-2, memo), topDownDP(nums, i-1, memo));
        }
        return memo[i];
    }
    
    //bottom-up, without memo or extra memory
    public int bottomUpDP(int[] nums){
        int a = 0, b = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int temp = b;
            b = Math.max(a + nums[i], b);
            a = temp;
        }
        
        return b;
    }
}


