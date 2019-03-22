class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = 0;
        
        while(start <= end){
            mid = (start + end) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                if(mid+1 >= nums.length){
                    return mid+1;
                }else if(mid + 1 < nums.length && nums[mid+1] > target){
                    return mid+1;
                }
                start = mid + 1;
            }else{
                if(mid - 1 < 0){
                    return mid;
                }else if(mid - 1 >= 0 && nums[mid-1] < target){
                    return mid;
                }
                end = mid - 1;
            }
        }
        return 0;
    }
}
