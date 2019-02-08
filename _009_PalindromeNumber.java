class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        
        //reverse the integer, and check whether they are same
        //Leetcode-007: Reverse an Integer
        int result = 0, original = x;
        while(x != 0){
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if((newResult - tail)/10 != result){
                //int overflow...
                return false;
            }
            x = x / 10;
            result = newResult;
        }
        return result == original? true : false;
    }
}
