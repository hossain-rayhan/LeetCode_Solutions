//https://leetcode.com/problems/number-of-1-bits/discuss/55099/Simple-Java-Solution-Bit-Shifting

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ones = 0;
        while(n != 0){
            ones = ones + (n & 1);
            n = n >>> 1;
        }
        
        return ones;
    }
}
