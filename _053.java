public class _053 {

    int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
   	 _053 obj = new _053();
   	 int arr[] = { -5, 2, 4, 1 };
   	 System.out.println(obj.maxSubArray(arr));
    }

    public int maxSubArray(int nums[]) {
   	 int size = nums.length;
   	 int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

   	 for (int i = 0; i < size; i++) {
   		 max_ending_here = max_ending_here + nums[i];
   		 if (max_so_far < max_ending_here)
   			 max_so_far = max_ending_here;
   		 if (max_ending_here < 0)
   			 max_ending_here = 0;
   	 }
   	 return max_so_far;
    }
}

