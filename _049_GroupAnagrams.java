class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String s = strs[i];
            String key = hash(s);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(s);
            map.put(key, list);
        }
        for(List<String> sList : map.values()){
            anagrams.add(sList);
        }
        return anagrams;
    }
    
    public String hash(String s){
        int[] alphabets = new int[26];
        for(int i = 0; i < s.length(); i++){
            alphabets[s.charAt(i) - 'a']++;
        }
        String key = "";
        for(int i = 0; i < alphabets.length; i++){
            key += ('a' + i) + alphabets[i]; 
        }
        return key;
    }
}
