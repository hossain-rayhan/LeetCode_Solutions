class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    list.add(temp);
                    left++;
                    right--;
                    while( left < nums.length && nums[left] == nums[left-1]){
                        left++;
                    }
                    while(right > i && nums[right] == nums[right+1]){
                        right--;
                    }
                }
            }
        }
        return list;
    }
}
