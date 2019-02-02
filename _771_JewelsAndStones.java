class Solution {
    public int numJewelsInStones(String J, String S) {
        int[] lowerCaseCounter = new int[26];
        int[] upperCaseCounter = new int[26];
        
        for(int i = 0; i < J.length(); i++){
            char ch = J.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                lowerCaseCounter[ch - 'a']++;
            }else{
                upperCaseCounter[ch - 'A']++;
            }
        }
        
        int total = 0;
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                if(lowerCaseCounter[ch - 'a'] > 0){
                    total++;
                };
            }else{
                if(upperCaseCounter[ch - 'A'] > 0){
                    total++;
                };
            }
        }
        return total;
    }
}
