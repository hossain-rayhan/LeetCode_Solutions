//https://leetcode.com/problems/subsets/discuss/122645/3ms-easiest-solution-no-backtracking-no-bit-manipulation-no-dfs-no-bullshit
//Its called the level order traversal BFS

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            int size = result.size();
            
            for(int j = 0; j < size; j++){
                List<Integer> subset = new ArrayList<Integer>(result.get(j));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
}
