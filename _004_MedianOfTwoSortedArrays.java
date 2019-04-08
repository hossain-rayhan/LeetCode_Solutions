//https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2496/Concise-JAVA-solution-based-on-Binary-Search

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = m + n;
        
        if(l % 2 == 0){
            int left = findKth(nums1, 0, nums2, 0, l / 2);
            int right = findKth(nums1, 0, nums2, 0, (l / 2) + 1);
            return (double) (left + right)/ 2.0;
        }else{
            return (double) findKth(nums1, 0, nums2, 0, (l / 2) + 1);
        }
    }
    
    public int findKth(int[] a, int aStart, int[] b, int bStart, int k){
        if(aStart >= a.length){
            return b[bStart + k - 1];
        }
        if(bStart >= b.length){
            return a[aStart + k - 1];
        }
        if(k == 1){
            return Math.min(a[aStart] , b[bStart]);
        }
        
        int aMid = aStart + k/2 - 1;
        int bMid = bStart + k/2 - 1;
        int aVal = aMid >= a.length? Integer.MAX_VALUE : a[aMid];
        int bVal = bMid >= b.length? Integer.MAX_VALUE : b[bMid];
        
        if(aVal <= bVal){
            return findKth(a, aMid + 1, b, bStart, k - k/2);
        }else{
            return findKth(a, aStart, b, bMid + 1, k - k/2);
        }
    }
}

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
