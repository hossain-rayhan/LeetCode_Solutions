class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        
        int[] total = new int[l1 + l2];
        int i = 0, j = 0, k = 0;
        while(i < l1 && j < l2){
            if(nums1[i] < nums2[j]){
                total[k++] = nums1[i++];
            }else{
                total[k++] = nums2[j++];
            }
        }
        while(i < l1){
            total[k++] = nums1[i++];
        }
        while(j < l2){
            total[k++] = nums2[j++];
        }
        
        if(total.length % 2 == 0){
            int mid = total.length / 2;
            double result = (total[mid-1] + total[mid])/2.0;
            return result;
        }else{
            double result = total[total.length / 2]/1.0;
            return result;
        }
    }
}
