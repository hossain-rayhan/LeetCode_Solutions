class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int twoSum = A[i] + B[j];
                map.put(twoSum, map.getOrDefault(twoSum, 0) + 1);
            }
        }
        
        int result = 0;
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int twoSum = C[i] + D[j];
                result += map.getOrDefault(-1 * twoSum, 0);
            }
        }
        
        return result;
    }
}
