class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int r = nums.length - k + 1;
        int[] result = new int[r];
        
        int max = nums[0];
        int maxIndex = 0;
        for(int i = 1; i < k; i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        int index = 0;
        result[index++] = max;
        
        for(int i = k; i < nums.length; i++){
            if(i-k == maxIndex){
                int j = (i-k+1);
                max = nums[j];
                maxIndex = j;
                j++;
                while(j <= i){
                    if(nums[j] > max){
                        max = nums[j];
                        maxIndex = j;
                    }
                    j++;
                }
            }else{
                if(nums[i] > max){
                    max = nums[i];
                    maxIndex = i;
                }
            }
            result[index++] = max;
        }
        return result;
    }
}
