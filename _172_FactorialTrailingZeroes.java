class Solution {
    public int trailingZeroes(int n) {
        //all trailing zeros are from the factors of 5 * 2
        //we can count the total factors of 5
        
        return n == 0? 0 : n/5 + trailingZeroes(n/5);
    }
}
