class Solution {
    public void rotate(int[] nums, int k) {
        //rotateNoSpace(nums, k);
        rotateReverse(nums, k);
    }
    
    //Best solution ever
    //Reverse three times
    public void rotateReverse(int[] nums, int k){
        int n = nums.length;
        
        //in case k is greater than the length
        k = k % n;
        
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    //Not a smart solution
    public void rotateNoSpace(int[] nums, int k){
        //in case k is greater than the length
        k = k % nums.length;
        
        for(int i = 0; i < k; i++){
            int last = nums[nums.length-1];
            for(int j = nums.length - 1; j >= 1; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = last;
        }
    }
}
