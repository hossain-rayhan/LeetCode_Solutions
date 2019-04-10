class Solution {
    int LIMIT = 6;
    public int findMinStep(String board, String hand) {
        int[] freq = new int[26];
        for(int i = 0; i < hand.length(); i++){
            freq[hand.charAt(i) - 'A']++;
        }
        
        int requiredBall = helper(board + "*", freq);
        return requiredBall == LIMIT? -1 : requiredBall;
    }
    
    public int helper(String s, int[] freq){
        s = removeConsecutive(s);
        if(s.equals("*")){
            return 0;
        }
        int counter = LIMIT, need = 0;
        for(int i = 0, j = 0; j < s.length(); j++){
            if(s.charAt(i) == s.charAt(j)){
                continue;
            }
            need = 3 - (j - i);
            if(freq[s.charAt(i) - 'A'] >= need){
                freq[s.charAt(i) - 'A'] -= need; //choose
                counter = Math.min(counter, need + helper(s.substring(0, i) + s.substring(j), freq)); //explore
                freq[s.charAt(i) - 'A'] += need; //undo
            }
            i = j;
        }
        return counter;
    }
    
    public String removeConsecutive(String s){
        for(int i = 0, j = 0; j < s.length(); j++){
            if(s.charAt(j) == s.charAt(i))
                continue;
            if(j-i >= 3){
                return removeConsecutive(s.substring(0, i) + s.substring(j));
            }else{
                i = j;
            }
        }
        return s;
    }
}
