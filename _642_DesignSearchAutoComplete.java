class AutocompleteSystem {

    class TrieNode{
        char key;
        HashMap<Character, TrieNode> childrenMap;
        HashMap<String, Integer> freqMap; //will store all sentences in this path with count
        public TrieNode(char key){
            this.key = key;
            childrenMap = new HashMap<>();
            freqMap = new HashMap<>();
        }
    }
    
    TrieNode root;
    StringBuilder sb;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode('0');
        sb = new StringBuilder();
        
         for(int i = 0; i < sentences.length; i++){
             buildTrie(sentences[i], times[i]);
         }
    }
    
    //First Solution: Using Trie, ideal solution for this prefix problem
    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        if(c == '#'){
            buildTrie(sb.toString(), 1);
            sb.setLength(0);
            return result;
        }
        
        sb.append(c);
        String query = sb.toString();
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getValue() == b.getValue()? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()));
        
        TrieNode n = root;
        for(char ch : query.toCharArray()){
            if(n.childrenMap.get(ch) == null){
                return result;
            }
            n = n.childrenMap.get(ch);
        }
        for(Map.Entry<String, Integer> entry: n.freqMap.entrySet()){
            pq.add(entry);
        }
      
        int k = 3;
        while(k-- > 0 && !pq.isEmpty()){
            result.add(pq.remove().getKey());
        }
        return result;
        
    }
    
    public void buildTrie(String sentence, int count){
        TrieNode n = root;
        for(char ch : sentence.toCharArray()){
            TrieNode next = n.childrenMap.get(ch);
            if(next == null){
                next = new TrieNode(ch);
                n.childrenMap.put(ch, next);
            }
            n = n.childrenMap.get(ch);
            n.freqMap.put(sentence, n.freqMap.getOrDefault(sentence, 0) + count);
        }
    }
    
    /**
    //Second Solution Start
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
    //2nd Solution
    //without Tire, Using HashMap and PriorityQueue- not very efficient
    public List<String> input_2(char c) {
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
    //Second Solution End
    **/
    
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
