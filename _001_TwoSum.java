class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] resultArray = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                resultArray[0] = map.get(target-nums[i]);
                resultArray[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return resultArray;
    }
}
