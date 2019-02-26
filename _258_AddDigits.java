//https://dgeekspot.wordpress.com/2015/11/17/digital-root-algorithm/

class Solution {
    public int addDigits(int num) {
        return digital_root_algo(num);
    }
    
    public int digital_root_algo(int num){
        return (1 + (num-1) % 9);
    }
}
