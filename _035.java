package main;

public class _035 {
	public static void main(String[] args) {
		int nums[] = {2, 3, 4, 5, 8};
		System.out.println(searchInsert(nums, 7));
	}
	
	public static int searchInsert(int[] nums, int target) {
		int l = nums.length;
		if(l <= 0)
			return 0;
		
		int i = 0;
		for(i = 0; i < l; i++){
			if(nums[i] >= target)
				return i;
			
		}
		
		return i;
    }
}
