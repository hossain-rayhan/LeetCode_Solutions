class AutocompleteSystem {

    HashMap<String, Integer> db;
    StringBuilder sb;
    public AutocompleteSystem(String[] sentences, int[] times) {
        db = new HashMap<>();
        sb = new StringBuilder();
        
        for(int i = 0; i < sentences.length; i++){
            int count = db.getOrDefault(sentences[i], 0) + times[i];
            db.put(sentences[i], count);
        }
    }
    
    //without Tire, Using HashMap and PriorityQueue- not very efficient
    public List<String> input(char c) {
        if(c == '#'){
            String s = sb.toString();
            int count = db.getOrDefault(s, 0) + 1;
            db.put(s, count);
            sb.setLength(0);
            return new ArrayList<String>();
        }
        sb.append(c);
        String query = sb.toString();
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue()? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        for(Map.Entry<String, Integer> entry : db.entrySet()){
            if(entry.getKey().startsWith(query)){
                pq.add(entry);
            }
        }
        
        List<String> result = new ArrayList<>();
        int k = 3;
        while(k-- > 0 && !pq.isEmpty()){
            result.add(pq.remove().getKey());
        }
        return result;
    }
    
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
