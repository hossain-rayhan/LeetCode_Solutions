class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(result, new ArrayList<>(), nums);
        
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums){
        if(tempList.size() == nums.length){
            //if all the items are added
            result.add(new ArrayList<Integer>(tempList));
        }else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])){ //item already added
                    continue;
                }
                
                tempList.add(nums[i]);
                backtrack(result, tempList, nums);
                
                //will remove the last one item when list is full
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
