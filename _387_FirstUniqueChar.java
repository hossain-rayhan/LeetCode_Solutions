class Solution {
    public int firstUniqChar(String s) {
        int[] counter = new int[26];
        int index = -1;
        for(int i = 0; i < s.length(); i++){
            counter[s.charAt(i) - 97]++;
        }
        
        for(int i = 0; i < s.length(); i++){
            if(counter[s.charAt(i) - 97] == 1){
                index = i;
                break;
            }
        }
        return index;
    }
}
