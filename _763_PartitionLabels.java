class Solution {
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        
        int[] lastIndex = new int[26];
        
        for(int i = 0; i < 26; i++){
            lastIndex[i] = -1;
        }
        
        for(int i = 0; i < S.length(); i++){
            lastIndex[S.charAt(i) - 'a'] = i;
        }
        
        int start = 0, end = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < S.length(); i++){
            end = Math.max(end, lastIndex[S.charAt(i) - 'a']);
            if(i == end){
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }
}
