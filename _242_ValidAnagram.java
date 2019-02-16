class Solution {
    public boolean isAnagram(String s, String t) {
        int[] frequencyS = new int[26];    
        int[] frequencyT = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            frequencyS[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            frequencyT[t.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(frequencyS[i] != frequencyT[i]){
                return false;
            }
        }
        
        return true;
    }
}
