package main;

import java.util.Arrays;

public class _027 {
	public static void main(String[] args) {
		int a[] = {1,2,3,3,4,5,5,5};
		System.out.println(Arrays.toString(a));
		System.out.println(removeElement(a, 4));
		System.out.println(Arrays.toString(a));
	}
	
	public static int removeElement(int[] nums, int val) {
        int l = nums.length;
        
        if(l <= 0)
        	return 0;
        
        int matchCounter = 0;
        for(int i = 0; i < l; i++){
        	if(nums[i] != val){
        		nums[matchCounter++] = nums[i];
        	}
        }
        
        return matchCounter;
    }
}
