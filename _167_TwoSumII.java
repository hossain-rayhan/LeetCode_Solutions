class Solution {
    public int[] twoSum(int[] numbers, int target) {
        return twoSumTwoPointer(numbers, target);
    }
    
    public int[] twoSumTwoPointer(int[]numbers, int target){
        int left = 0, right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                int[] arr = {left+1, right+1};
                return arr;
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return null;
    }
}
