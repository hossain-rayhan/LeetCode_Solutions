//https://leetcode.com/problems/odd-even-jump/discuss/217981/JavaC%2B%2BPython-DP-idea-Using-TreeMap-or-Stack
class Solution {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];
        higher[n-1] = true;
        lower[n-1] = true;
        int result = 1;
        
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(A[n-1], n-1); //(value, index)
        for(int i = n - 2; i >= 0; i--){
            int val = A[i];
            Map.Entry highEntry = treeMap.ceilingEntry(val); //the smallest one from all the values which are greater or equal than val
            Map.Entry lowEntry = treeMap.floorEntry(val); //the greatest one from all the values which are lower or equal than val
            
            if(highEntry != null){
                higher[i] = lower[(int)highEntry.getValue()];
            }
            if(lowEntry != null){
                lower[i] = higher[(int)lowEntry.getValue()];
            }
            
            if(higher[i]){
                result++;
            }
            treeMap.put(val, i);
        }
        return result;
    }
}
