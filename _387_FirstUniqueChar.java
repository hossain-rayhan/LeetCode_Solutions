class Solution {
    public int firstUniqChar(String s) {
        return uniqueCharArray(s);
        //return uniqueLinkedHashMap(s);
    }
    
    public int uniqueCharArray(String s){
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 97]++;
        }
        int index = -1;
        for(int i = 0; i < s.length(); i++){
            if(freq[s.charAt(i) - 97] == 1){
                index = i;
                break;
            }
        }
        return index;
    }
    
    public int uniqueLinkedHashMap(String s){
        //maintains the order. Only HashMap cannot maintain the order
        Map<Character, Integer> map = new LinkedHashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                if(map.get(ch) != null){
                    map.remove(ch);
                }
            }else{
                set.add(ch);
                map.put(ch, i);
            }
        }
        return map.size() == 0? -1 : map.entrySet().iterator().next().getValue();
    }
}
