class Solution {
    public int numDecodings(String s) {
        return topDownMemo(s);
    }
    
    //solve using DP: top-down + memo
    public int topDownMemo(String s){
        if(s == null || s.length() == 0){
            return 1;
        }
        int n = s.length();
        int[] memo = new int[n+1];
        memo[n] = 1;
        memo[n-1] = s.charAt(n-1) == '0'? 0 : 1;
        for(int i = n-2; i >= 0; i--){
            if(s.charAt(i) == '0'){
                memo[i] = 0;
                continue;
            }
            int num = Integer.parseInt(s.substring(i, i+2));
            if(num <= 26){
                memo[i] = memo[i+1] + memo[i+2];
            }else{
                memo[i] = memo[i+1];
            }
        }
        return memo[0];
    }
}
