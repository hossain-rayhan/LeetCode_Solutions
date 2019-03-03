class Solution {
    public int climbStairs(int n) {
        //return topDown(n);
        
        return bottomUp(n);
    }
    
    //Bottom-Up using two variables, super fast
    public int bottomUp(int n){
        if(n <= 1){
            return 1;
        }
        int a = 1, b = 1;
        for(int i = 2; i <= n; i++){
            int temp = b;
            b = a + b;
            a = temp;
        }
        
        return b;
    }
    
    //TopDown without memoization, very very slow
    public int topDown(int n){
        if(n <= 1){
            return 1;
        }
        
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
