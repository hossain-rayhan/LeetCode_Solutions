//https://leetcode.com/problems/first-missing-positive/discuss/17073/Share-my-O(n)-time-O(1)-space-solution
class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        
        //bring all positive numbers before zero
        int k = partition(nums) + 1;
        
        //index zero to k are all the positive numbers
        for(int i = 0; i < k; i++){
            int val = Math.abs(nums[i]);
            if(val <= k){
                //if value is inside range, store the negative
                nums[val - 1] = nums[val - 1] < 0? nums[val - 1] : -nums[val - 1];
            }
        }
        
        //finally the first index with positive number is the missing
        int firstMissingIndex = k;
        for(int i = 0; i < k; i++){
            if(nums[i] > 0){
                firstMissingIndex = i; //missing index found
                break;
            }
        }
        return firstMissingIndex + 1;
    }
    
    public int partition(int[] a){
        int index = -1;
        for(int i = 0; i < a.length; i++){
            if(a[i] > 0){
                index++;
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
        }
        return index;
    }
}
