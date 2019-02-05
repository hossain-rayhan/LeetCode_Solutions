class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>(wordDict);
        boolean[] found = new boolean[s.length() + 1];
        
        found[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(found[j] == true && set.contains(s.substring(j, i))){
                    found[i] = true;
                    break;
                }
            }
        }
        return found[s.length()];
    }
}
