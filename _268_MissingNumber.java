class Solution {
    //Using XOR we can solve- no extra space; linear time
    public int missingNumber(int[] nums) {
        //take the XOR of 1 to N
        int all = 0;
        for(int i = 1; i <= nums.length; i++){
            all = all ^ i;
        }
        
        
        //take the XOR of the numbers of the array
        int arrValue = 0;
        for(int i = 0; i < nums.length; i++){
            arrValue = arrValue ^ nums[i];
        }
        
        //now take the XOR of the all withe the arr values; we will get the missing element
        int missing = all ^ arrValue;
        
        return missing;
    }
}
