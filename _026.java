package main;

import java.util.Arrays;

public class _026 {
	public static void main(String[] args) {
		int a[] = {1,1,4,5,5,5,8,11,11};
		System.out.println(Arrays.toString(a));
		int count = removeDuplicates(a);
		
		System.out.println(count);
		
		System.out.println(Arrays.toString(a));
	}
	
    public static int removeDuplicates(int[] nums) {
        int l = nums.length;
        
        if(l <= 0)
        	return 0;
        int counter = 0, current;
        
        current = nums[0];
        counter++;
        
        for(int i = 1; i < l; i++){
        	if(nums[i] != current){
        		current = nums[i];
        		nums[counter++] = nums[i];
        	}
        }
        
        return counter;
    }
}
