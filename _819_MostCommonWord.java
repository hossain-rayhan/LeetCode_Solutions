class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedSet = new HashSet<String>();
        for(String s : banned){
            bannedSet.add(s);
        }
        
        HashMap<String, Integer> validMap = new HashMap<String, Integer>();
        String max = "";
        int maxCount = 0;
        
        //replace now-word characters, convert to lowercase and split
        String[] arr = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
        for(String s : arr){
            if(!bannedSet.contains(s)){
                int count = validMap.getOrDefault(s, 0) + 1;
                validMap.put(s, count);
                
                if(count > maxCount){
                    maxCount = count;
                    max = s;
                }
            }
        }
        return max;
    }
}
