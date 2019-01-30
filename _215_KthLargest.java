class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
     
          public static int quickSelect(int[] arr, int left, int right, int k){
                  //System.out.println("L-R: " + left + " ; " + right);
                  //System.out.println(Arrays.toString(arr));
                  if(left == right)
                          return arr[left];
  
                  int pivot = (left+right)/2;
                  int pivotIndex = partition(arr, left, right, pivot);
  
                  if(arr.length-k == pivotIndex){
                          return arr[pivotIndex];
                  }else if(arr.length-k < pivotIndex){
                          return quickSelect(arr, left, pivotIndex-1, k);
                  }else{
                          return quickSelect(arr, pivotIndex+1, right, k);
                  }
          }
  
        public static int partition(int[] arr, int start, int end, int pivot){
    		// 1. move pivot to end
	        int pivotValue = arr[pivot];
		    swap(arr, pivot, end);
        	int index = start;

		    // 2. move all smaller elements to the start
		    for(int i = start; i <= end; i++){
			    if(arr[i] < pivotValue)
			    	swap(arr, index++, i);
		    }

		    // 3. move pivot to its final place
		    swap(arr, index, end);
		    
            return index;
	    }
  
	    public static void swap(int[] A, int i, int j){
		    int temp = A[i];
		    A[i] = A[j];
		    A[j] = temp;
	    }

}
