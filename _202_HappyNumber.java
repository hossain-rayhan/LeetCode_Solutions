//https://leetcode.com/problems/happy-number/discuss/56917/My-solution-in-C(-O(1)-space-and-no-magic-math-property-involved-)

class Solution {
    //for detecting the same number or loop, we can use Floy's Cycle Dectecion algo
    //like- cycle in a linked list
    
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        
        do{
            slow = getDigitSquareSum(slow);
            fast = getDigitSquareSum(fast);
            fast = getDigitSquareSum(fast);
        }while(slow != fast);
        
        return slow == 1;
    }
    
    public int getDigitSquareSum(int n){
        int sum = 0;
        while(n != 0){
            int temp = n % 10;
            sum += (temp * temp);
            n = n / 10;
        }
        return sum;
    }
}
