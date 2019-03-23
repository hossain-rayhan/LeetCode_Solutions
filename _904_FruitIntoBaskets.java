//https://leetcode.com/problems/fruit-into-baskets/discuss/170745/Problem%3A-Longest-Subarray-With-2-Elements

class Solution {
    public int totalFruit(int[] tree) {
        //Will consider the sequence: aaabbbbcccc
        int max = 0, currentSum = 0, a = -1, b = -1, countB = 0;
        for(int c : tree){
            currentSum = (c == a || c == b)? currentSum + 1: countB+1;
            if(c == b){
                countB++;
            }else{
                a = b;
                b = c;
                countB = 1;
            }
            
            max = Math.max(max, currentSum);
        }
        return max;
    }
}
