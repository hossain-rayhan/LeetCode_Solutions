class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int l = cost.length;
        if(l <= 1){
            return 0;
        }

        for(int i = 2; i < cost.length; i++){
            cost[i] = Math.min(cost[i-1], cost[i-2]) + cost[i];
        }
        
        return Math.min(cost[l-1], cost[l-2]);
    }
}
