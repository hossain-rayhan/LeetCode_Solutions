class Solution {
    //XOR should handle it
    //N ^ 0 = N
    //N ^ N = 0
    public int singleNumber(int[] nums) {
        int ans = 0;
        
        for(int n : nums){
            ans = ans ^ n;
        }
        return ans;
    }
}
