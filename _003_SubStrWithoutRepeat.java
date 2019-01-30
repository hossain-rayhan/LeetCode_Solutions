class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, lastBreakIndex = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch) && map.get(ch) >= lastBreakIndex){
                if((i-lastBreakIndex) > max){
                    max = i - lastBreakIndex;
                }
                //move the last index to the right of condition break
                lastBreakIndex = map.get(ch) + 1;
            }
            map.put(ch, i);
        }
        if((s.length()-lastBreakIndex) > max){
            max = s.length()-lastBreakIndex;
        }
        return max;
    }
}
