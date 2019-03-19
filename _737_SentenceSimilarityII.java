class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length){
            return false;
        }    
        
        HashMap<String, HashSet<String>> mapping = new HashMap<>();
        for(String[] w : pairs){
            if(!mapping.containsKey(w[0])){
                mapping.put(w[0], new HashSet<String>());
            }
            mapping.get(w[0]).add(w[1]);
           
            if(!mapping.containsKey(w[1])){
                mapping.put(w[1], new HashSet<String>());
            }
            mapping.get(w[1]).add(w[0]);
        }
        
        for(int i = 0; i < words1.length; i++){
            if(words1[i].equals(words2[i])){
                continue;
            }
            if(!mapping.containsKey(words1[i]) || !mapping.containsKey(words2[i])){
                return false;
            }
            if(!isSimilar(words1[i], words2[i], mapping, new HashSet<>())){
                return false;
            }
        }
        return true;
    }
    
    //concept of graph traversal, dfs.
    public boolean isSimilar(String source, String target, HashMap<String, HashSet<String>> mapping, HashSet<String> isVisited){
        if(mapping.get(source).contains(target)){
            return true;
        }
        if(!isVisited.contains(source)){
            isVisited.add(source);
            for(String similar : mapping.get(source)){
                if(isSimilar(similar, target, mapping, isVisited)){
                    return true;
                }
            }    
            
        }
        return false;
    }
}
