class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordFreqMap = new HashMap<>();
        for(String word : words){
            wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );
        
        for(Map.Entry<String, Integer> entry : wordFreqMap.entrySet()){
            pq.add(entry);
            if(pq.size() > k){
                pq.remove();
            }
        }
        
        List<String> result = new ArrayList<>();
        while(k > 0){
            result.add(0, pq.remove().getKey());
            k--;
        }
        return result;
    }
}
