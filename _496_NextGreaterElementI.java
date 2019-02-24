
//https://leetcode.com/problems/next-greater-element-i/discuss/97595/Java-10-lines-linear-time-complexity-O(n)-with-explanation
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < nums2.length-1; i++){
            stack.push(nums2[i]);
            if(nums2[i+1] > stack.peek()){
                while(!stack.isEmpty() && stack.peek() < nums2[i+1]){
                    map.put(stack.pop(), nums2[i+1]);
                }
            }
        }
        
        for(int i = 0; i < nums1.length; i++){
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        
        return nums1;
    }
}
